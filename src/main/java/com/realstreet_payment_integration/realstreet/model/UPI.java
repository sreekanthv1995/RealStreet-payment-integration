package com.realstreet_payment_integration.realstreet.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("UPI")
@Data
public class UPI extends Payment {

    private String upiId;
}
