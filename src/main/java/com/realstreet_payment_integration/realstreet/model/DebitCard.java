package com.realstreet_payment_integration.realstreet.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("DebitCard")
@Data
public class DebitCard extends Payment {

    private Long accountNumber;
    private String cardHolderName;
    private String expiryDate;
    private Integer ccv;
}
