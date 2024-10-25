package com.realstreet_payment_integration.realstreet.controller;

import com.realstreet_payment_integration.realstreet.dto.LoginRequest;
import com.realstreet_payment_integration.realstreet.dto.UserDto;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import com.realstreet_payment_integration.realstreet.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/signup")
    public ResponseEntity<UserEntity>createUser(@RequestBody UserDto userDto){
        log.info(" user"+ userDto);
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseEntity<String>> handleLogin(@RequestBody LoginRequest loginRequest){
        log.info(loginRequest.getUsername());
        return ResponseEntity.ok(userService.login(loginRequest));
    }
}
