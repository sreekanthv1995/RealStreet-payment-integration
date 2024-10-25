package com.realstreet_payment_integration.realstreet.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("NetBanking")
@Data
public class NetBanking extends Payment {

    private String bankName;
    private Long accountNumber;
    private String ifscCode;
}
