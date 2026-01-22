package com.devithedev.eazystore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.devithedev.eazystore.constants.ApplicationConstants;
import com.devithedev.eazystore.dto.ContactResponseDto;
import com.devithedev.eazystore.dto.OrderItemResponseDto;
import com.devithedev.eazystore.dto.OrderRequestDto;
import com.devithedev.eazystore.dto.OrderResponseDto;
import com.devithedev.eazystore.dto.ResponseDto;
import com.devithedev.eazystore.entity.Contact;
import com.devithedev.eazystore.entity.Customer;
import com.devithedev.eazystore.entity.Order;
import com.devithedev.eazystore.entity.OrderItem;
import com.devithedev.eazystore.entity.Product;
import com.devithedev.eazystore.exception.ResourceNotFoundException;
import com.devithedev.eazystore.repository.OrderRepository;
import com.devithedev.eazystore.repository.ProductRepository;
import com.devithedev.eazystore.service.IOrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final ProfileServiceImpl profileServiceImpl;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public void createOrder(OrderRequestDto orderRequestDto) {
        Customer customer = this.profileServiceImpl.getAuthenticatedCustomer();
        Order order = new Order();
        order.setCustomer(customer);
        BeanUtils.copyProperties(orderRequestDto, order);
        order.setOrderStatus(ApplicationConstants.ORDER_STATUS_CREATED);

        // Map order item
        List<OrderItem> orderItems = orderRequestDto.items().stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            Product product = productRepository.findById(item.productId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "ProductID",
                            item.productId().toString()));
            orderItem.setProduct(product);
            orderItem.setPrice(item.price());
            orderItem.setQuantity(item.quantity());
            return orderItem;
        }).collect(Collectors.toList());
        order.setOrderItems(orderItems);
        this.orderRepository.save(order);
    }

    // Get customer order
    @Override
    public List<OrderResponseDto> loadOrderCustomer() {
        Customer customer = profileServiceImpl.getAuthenticatedCustomer();
        List<Order> orders = orderRepository.findByCustomerOrderByCreatedAtDesc(customer);
        return orders.stream().map(this::mapToOrderResponseDTO).collect(Collectors.toList());
    }

    private OrderResponseDto mapToOrderResponseDTO(Order order) {
        List<OrderItemResponseDto> itemDtos = order.getOrderItems().stream()
                .map(this::mapToOrderItemResponseDTO).collect(Collectors.toList());
        OrderResponseDto orderResponseDto = new OrderResponseDto(order.getOrderId(), order.getOrderStatus(),
                order.getCreatedAt().toString(), order.getTotalPrice(), itemDtos);
        return orderResponseDto;
    }

    private OrderItemResponseDto mapToOrderItemResponseDTO(OrderItem orderItem) {
        OrderItemResponseDto itemDTO = new OrderItemResponseDto(
                orderItem.getProduct().getName(), orderItem.getQuantity(),
                orderItem.getPrice(), orderItem.getProduct().getImageUrl());
        return itemDTO;
    }

    // Get all pending customer order for admin
    @Override
    public List<OrderResponseDto> getAllPendingOrders() {
        List<Order> orders = orderRepository.findByOrderStatus(ApplicationConstants.ORDER_STATUS_CREATED);
        return orders.stream().map(this::mapToOrderResponseDTO).collect(Collectors.toList());
    }

    // Update order status
    @Override
    public Order updateOrderStatus(Long orderId, String orderStatus) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order", "OrderID", orderId.toString()));
        order.setOrderStatus(orderStatus);
        return orderRepository.save(order);
    }

}
