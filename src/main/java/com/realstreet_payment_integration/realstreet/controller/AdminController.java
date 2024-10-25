package com.realstreet_payment_integration.realstreet.controller;

import com.realstreet_payment_integration.realstreet.model.Payment;
import com.realstreet_payment_integration.realstreet.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllTransactions(){
        return ResponseEntity.ok(paymentService.getAllTransactions());
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment>getTransactionById(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.getTransactionById(id));
    }
}
