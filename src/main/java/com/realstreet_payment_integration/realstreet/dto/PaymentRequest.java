package com.realstreet_payment_integration.realstreet.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
public class PaymentRequest {

    private Long id;
    private Double amount;
    private LocalDate transactionDate;
    private String bankName;
    private String ifscCode;
    private Long cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private Integer ccv;
    private Long accountNumber;
    private String upiId;

}
