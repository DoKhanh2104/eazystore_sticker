package com.devithedev.eazystore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devithedev.eazystore.dto.PaymentIntentRequestDto;
import com.devithedev.eazystore.dto.PaymentIntentResponseDto;
import com.devithedev.eazystore.service.IPaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final IPaymentService iPaymentService;

    @PostMapping("/create-payment-intent")
    public ResponseEntity<PaymentIntentResponseDto> createPaymentIntent(
            @RequestBody PaymentIntentRequestDto paymentIntentRequestDto) {
        PaymentIntentResponseDto paymentIntentResponseDto = this.iPaymentService
                .createPaymentIntent(paymentIntentRequestDto);
        return ResponseEntity.ok(paymentIntentResponseDto);
    }
}
