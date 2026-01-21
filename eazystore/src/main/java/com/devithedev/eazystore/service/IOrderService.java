package com.devithedev.eazystore.service;

import com.devithedev.eazystore.dto.OrderRequestDto;

public interface IOrderService {
    void createOrder(OrderRequestDto orderRequestDto);
}
