package com.realstreet_payment_integration.realstreet.service.user;

import com.realstreet_payment_integration.realstreet.dto.AuthenticationResponse;
import com.realstreet_payment_integration.realstreet.dto.LoginRequest;
import com.realstreet_payment_integration.realstreet.dto.SignupResponse;
import com.realstreet_payment_integration.realstreet.dto.UserDto;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {

    SignupResponse createUser(UserDto userDto);
    AuthenticationResponse login(LoginRequest loginRequest);
    UserEntity getLoggedInUser();

}
