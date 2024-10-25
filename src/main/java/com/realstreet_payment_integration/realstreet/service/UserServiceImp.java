package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.LoginRequest;
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
    public UserEntity createUser(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username " + userDto.getUsername() + " is already taken.");
        }
        return getUserEntity(userDto);
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
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(), loginRequest.getPassword()));
            return ResponseEntity.status(HttpStatus.OK).body("Login Success");
        } catch (BadCredentialsException e) {
            log.error("Bad credentials: ", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid User");
        } catch (InternalAuthenticationServiceException e) {
            log.error("Internal Authentication Service Exception: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication failed");
        } catch (Exception e) {
            log.error("Other Authentication Exception: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during login");
        }
    }

}
