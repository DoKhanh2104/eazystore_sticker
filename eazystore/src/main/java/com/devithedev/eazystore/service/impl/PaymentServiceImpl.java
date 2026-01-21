package com.devithedev.eazystore.service.impl;

import org.springframework.stereotype.Service;

import com.devithedev.eazystore.dto.PaymentIntentRequestDto;
import com.devithedev.eazystore.dto.PaymentIntentResponseDto;
import com.devithedev.eazystore.service.IPaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Override
    public PaymentIntentResponseDto createPaymentIntent(PaymentIntentRequestDto paymentIntentRequestDto) {
        try {
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(paymentIntentRequestDto.amount())
                    .setCurrency(paymentIntentRequestDto.currency())
                    .addPaymentMethodType("card").build();
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            return new PaymentIntentResponseDto(paymentIntent.getClientSecret());
        } catch (StripeException e) {
            throw new RuntimeException("Failed to create payment intent", e);
        }
    }

}
