package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.PaymentRequest;
import com.realstreet_payment_integration.realstreet.model.UPI;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import com.realstreet_payment_integration.realstreet.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class UPIService {

    @Autowired
    private UserService userService;
    public UPI createUpiPayment(PaymentRequest paymentRequest){
        UPI upi = new UPI();
        upi.setAmount(paymentRequest.getAmount());
        upi.setTransactionDate(LocalDate.now());
        upi.setUpiId(paymentRequest.getUpiId());
        UserEntity user = userService.getLoggedInUser();
        upi.setUser(user);
        return upi;
    }
}
