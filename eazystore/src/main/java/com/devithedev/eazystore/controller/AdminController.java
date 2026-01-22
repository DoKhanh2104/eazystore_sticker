package com.devithedev.eazystore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devithedev.eazystore.constants.ApplicationConstants;
import com.devithedev.eazystore.dto.ContactResponseDto;
import com.devithedev.eazystore.dto.OrderResponseDto;
import com.devithedev.eazystore.dto.ResponseDto;
import com.devithedev.eazystore.entity.Contact;
import com.devithedev.eazystore.entity.Order;
import com.devithedev.eazystore.service.IContactService;
import com.devithedev.eazystore.service.IOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final IOrderService iOrderService;
    private final IContactService iContactService;

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getAllPendingOrders() {
        return ResponseEntity.ok(iOrderService.getAllPendingOrders());
    }

    @PatchMapping("/orders/{orderId}/confirm")
    public ResponseEntity<ResponseDto> confirmOrder(@PathVariable Long orderId) {
        Order confirmOrder = iOrderService.updateOrderStatus(orderId, ApplicationConstants.ORDER_STATUS_CONFIRMED);
        return ResponseEntity.ok(new ResponseDto("200", "Order #" + confirmOrder.getOrderId() + "has been approved"));
    }

    @PatchMapping("/orders/{orderId}/cancel")
    public ResponseEntity<ResponseDto> cancelOrder(@PathVariable Long orderId) {
        Order confirmOrder = iOrderService.updateOrderStatus(orderId, ApplicationConstants.ORDER_STATUS_CANCELLED);
        return ResponseEntity.ok(new ResponseDto("200", "Order #" + confirmOrder.getOrderId() + "has been cancalled"));
    }

    @GetMapping("/messages")
    public ResponseEntity<List<ContactResponseDto>> getAllOpenMessages() {
        return ResponseEntity.ok(iContactService.getOpenAllMessages());
    }

    @PatchMapping("/messages/{contactId}/close")
    public ResponseEntity<ResponseDto> updateContactStatus(@PathVariable Long contactId) {
        Contact closeContact = iContactService.updateContactStatus(contactId, ApplicationConstants.CLOSED_MESSAGE);
        return ResponseEntity.ok(new ResponseDto("200", "Contact #" + closeContact.getId() + "has been closed"));
    }
}
