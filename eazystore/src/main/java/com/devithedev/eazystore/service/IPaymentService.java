package com.devithedev.eazystore.service;

import com.devithedev.eazystore.dto.PaymentIntentRequestDto;
import com.devithedev.eazystore.dto.PaymentIntentResponseDto;

public interface IPaymentService {
    PaymentIntentResponseDto createPaymentIntent(PaymentIntentRequestDto paymentIntentRequestDto);
}
