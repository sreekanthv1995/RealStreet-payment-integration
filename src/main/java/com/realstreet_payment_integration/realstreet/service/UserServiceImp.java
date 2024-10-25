package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.LoginRequest;
import com.realstreet_payment_integration.realstreet.dto.SignupResponse;
import com.realstreet_payment_integration.realstreet.dto.UserDto;
import com.realstreet_payment_integration.realstreet.model.Role;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import com.realstreet_payment_integration.realstreet.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public SignupResponse createUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username " + userDto.getUsername() + " is already taken.");
        }
        UserEntity user = getUserEntity(userDto);
        SignupResponse signupResponse = new SignupResponse();
        signupResponse.setUsername(user.getUsername());
        signupResponse.setMessage("User Crated");
        return signupResponse;
    }

    private UserEntity getUserEntity(UserDto userDto) {
        return userRepository.save(
                UserEntity.builder()
                        .username(userDto.getUsername())
                        .password(encoder.encode(userDto.getPassword()))
                        .email(userDto.getEmail())
                        .role(Role.USER)
                        .phoneNumber(userDto.getPhoneNumber())
                        .build()
        );
    }

    @Override
    public ResponseEntity<String> login(LoginRequest loginRequest) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(), loginRequest.getPassword()));
            return ResponseEntity.status(HttpStatus.OK).body("Login Success");
    }

    public UserEntity getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            return userRepository.findByUsername(userDetails.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        } else {
            throw new IllegalStateException("No authenticated user found");
        }
    }

}
