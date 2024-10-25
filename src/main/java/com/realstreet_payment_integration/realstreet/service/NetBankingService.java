package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.PaymentRequest;
import com.realstreet_payment_integration.realstreet.model.NetBanking;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class NetBankingService {

    public NetBanking createNetBankingPayment(PaymentRequest paymentRequest){
        NetBanking netBanking = new NetBanking();
        netBanking.setAmount(paymentRequest.getAmount());
        netBanking.setTransactionDate(LocalDate.now());
        netBanking.setAccountNumber(paymentRequest.getAccountNumber());
        netBanking.setBankName(paymentRequest.getBankName());
        netBanking.setIfscCode(paymentRequest.getIfscCode());
        return netBanking;
    }
}
