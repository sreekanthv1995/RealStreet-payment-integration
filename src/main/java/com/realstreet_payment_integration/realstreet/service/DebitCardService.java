package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.PaymentRequest;
import com.realstreet_payment_integration.realstreet.model.DebitCard;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class DebitCardService {

    public DebitCard createDebitCardPayment(PaymentRequest paymentRequest){
        DebitCard debitCard = new DebitCard();
        debitCard.setAmount(paymentRequest.getAmount());
        debitCard.setTransactionDate(LocalDate.now());
        debitCard.setAccountNumber(paymentRequest.getAccountNumber());
        debitCard.setExpiryDate(paymentRequest.getExpiryDate());
        debitCard.setCardHolderName(paymentRequest.getCardHolderName());
        debitCard.setCcv(paymentRequest.getCcv());
        return debitCard;
    }
}
