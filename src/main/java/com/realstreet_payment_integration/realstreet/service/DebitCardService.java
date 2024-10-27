package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.PaymentRequest;
import com.realstreet_payment_integration.realstreet.model.DebitCard;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import com.realstreet_payment_integration.realstreet.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DebitCardService {

    @Autowired
    private UserService userService;
    public DebitCard createDebitCardPayment(PaymentRequest paymentRequest){
        DebitCard debitCard = new DebitCard();
        debitCard.setAmount(paymentRequest.getAmount());
        debitCard.setTransactionDate(LocalDate.now());
        debitCard.setAccountNumber(paymentRequest.getAccountNumber());
        debitCard.setExpiryDate(paymentRequest.getExpiryDate());
        debitCard.setCardHolderName(paymentRequest.getCardHolderName());
        debitCard.setCcv(paymentRequest.getCcv());
        UserEntity user = userService.getLoggedInUser();
        debitCard.setUser(user);
        return debitCard;
    }
}
