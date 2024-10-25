package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.LoginRequest;
import com.realstreet_payment_integration.realstreet.dto.UserDto;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {

    UserEntity createUser(UserDto userDto);
    ResponseEntity<String> login(LoginRequest loginRequest);

}
