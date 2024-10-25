package com.realstreet_payment_integration.realstreet.repository;

import com.realstreet_payment_integration.realstreet.model.Role;
import com.realstreet_payment_integration.realstreet.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity>findByEmail(String email);
    Optional<UserEntity>findByUsername(String username);
    UserEntity findByRole(Role role);

}
