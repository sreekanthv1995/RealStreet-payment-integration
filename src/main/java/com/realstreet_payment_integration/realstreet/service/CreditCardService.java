package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.PaymentRequest;
import com.realstreet_payment_integration.realstreet.model.CreditCard;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class CreditCardService {

    @Autowired
    private UserService userService;
    public CreditCard createCreditCardPayment(PaymentRequest paymentRequest){
        CreditCard creditCard = new CreditCard();
        creditCard.setAmount(paymentRequest.getAmount());
        creditCard.setTransactionDate(LocalDate.now());
        creditCard.setCardNumber(paymentRequest.getCardNumber());
        creditCard.setCardHolderName(paymentRequest.getCardHolderName());
        creditCard.setExpiryDate(paymentRequest.getExpiryDate());
        creditCard.setCcv(paymentRequest.getCcv());
        UserEntity user = userService.getLoggedInUser();
        creditCard.setUser(user);
        return creditCard;
    }
}
