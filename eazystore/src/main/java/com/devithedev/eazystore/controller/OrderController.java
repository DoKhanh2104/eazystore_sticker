package com.devithedev.eazystore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devithedev.eazystore.dto.OrderRequestDto;
import com.devithedev.eazystore.dto.OrderResponseDto;
import com.devithedev.eazystore.service.IOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService iOrderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        this.iOrderService.createOrder(orderRequestDto);
        return ResponseEntity.ok("Order created successfully!");
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> loadOrderCustomer() {
        List<OrderResponseDto> orderResponseDto = iOrderService.loadOrderCustomer();
        return ResponseEntity.ok(orderResponseDto);
    }
}
