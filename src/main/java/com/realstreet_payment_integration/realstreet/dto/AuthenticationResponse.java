package com.realstreet_payment_integration.realstreet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthenticationResponse {

    private String userName;
    private String token;
}


