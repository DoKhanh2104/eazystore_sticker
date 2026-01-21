package com.devithedev.eazystore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.devithedev.eazystore.constants.ApplicationConstants;
import com.devithedev.eazystore.dto.OrderRequestDto;
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

}
