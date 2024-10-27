package com.realstreet_payment_integration.realstreet.controller;

import com.realstreet_payment_integration.realstreet.dto.AuthenticationResponse;
import com.realstreet_payment_integration.realstreet.dto.LoginRequest;
import com.realstreet_payment_integration.realstreet.dto.SignupResponse;
import com.realstreet_payment_integration.realstreet.dto.UserDto;
import com.realstreet_payment_integration.realstreet.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/signup")
    public ResponseEntity<SignupResponse>createUser(@RequestBody UserDto userDto){
        log.info(" user"+ userDto);
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> handleLogin(@RequestBody LoginRequest loginRequest){
        log.info(loginRequest.getUsername());
        return ResponseEntity.ok(userService.login(loginRequest));
    }


}
