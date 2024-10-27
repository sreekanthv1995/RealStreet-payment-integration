package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.PaymentRequest;
import com.realstreet_payment_integration.realstreet.model.NetBanking;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import com.realstreet_payment_integration.realstreet.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NetBankingService {

    @Autowired
    private UserService userService;
    public NetBanking createNetBankingPayment(PaymentRequest paymentRequest){
        NetBanking netBanking = new NetBanking();
        netBanking.setAmount(paymentRequest.getAmount());
        netBanking.setTransactionDate(LocalDate.now());
        netBanking.setAccountNumber(paymentRequest.getAccountNumber());
        netBanking.setBankName(paymentRequest.getBankName());
        netBanking.setIfscCode(paymentRequest.getIfscCode());
        UserEntity user = userService.getLoggedInUser();
        netBanking.setUser(user);
        return netBanking;
    }
}
