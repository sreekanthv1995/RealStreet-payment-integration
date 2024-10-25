package com.realstreet_payment_integration.realstreet.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("CreditCard")
@Data
public class CreditCard extends Payment {

    private Long cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private Integer ccv;

}
