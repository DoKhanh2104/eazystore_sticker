package com.devithedev.eazystore.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponseDto(Long orderId, String status, String createdAt, BigDecimal totalPrice,
                List<OrderItemResponseDto> items) {

}
