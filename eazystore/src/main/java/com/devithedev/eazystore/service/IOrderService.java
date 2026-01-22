package com.devithedev.eazystore.service;

import java.util.List;

import com.devithedev.eazystore.dto.OrderRequestDto;
import com.devithedev.eazystore.dto.OrderResponseDto;
import com.devithedev.eazystore.entity.Order;

public interface IOrderService {
    void createOrder(OrderRequestDto orderRequestDto);

    List<OrderResponseDto> loadOrderCustomer();

    List<OrderResponseDto> getAllPendingOrders();

    Order updateOrderStatus(Long orderId, String orderStatus);
}
