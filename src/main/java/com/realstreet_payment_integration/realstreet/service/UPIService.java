package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.PaymentRequest;
import com.realstreet_payment_integration.realstreet.model.UPI;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
@Service
public class UPIService {


    public UPI createUpiPayment(PaymentRequest paymentRequest){
        UPI upi = new UPI();
        upi.setAmount(paymentRequest.getAmount());
        upi.setTransactionDate(LocalDate.now());
        upi.setUpiId(paymentRequest.getUpiId());
        return upi;
    }
}
