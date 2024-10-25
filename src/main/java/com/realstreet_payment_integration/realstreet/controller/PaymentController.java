package com.realstreet_payment_integration.realstreet.controller;

import com.realstreet_payment_integration.realstreet.dto.PaymentRequest;
import com.realstreet_payment_integration.realstreet.dto.PaymentResponse;
import com.realstreet_payment_integration.realstreet.model.Payment;
import com.realstreet_payment_integration.realstreet.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentResponse>createTransaction(
            @RequestParam String paymentType, @RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.ok(paymentService.createTransaction(paymentType,paymentRequest));
    }

    @GetMapping("/payment-methods")
    public ResponseEntity<List<String>>getAllPaymentMethods(){
        return ResponseEntity.ok(paymentService.getAllPaymentMethods());
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>>getAllTransactions(){
        return ResponseEntity.ok(paymentService.getAllTransactions());
    }
}
