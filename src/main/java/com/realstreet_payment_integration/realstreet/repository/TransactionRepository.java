package com.realstreet_payment_integration.realstreet.repository;

import com.realstreet_payment_integration.realstreet.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Payment,Long> {
    @Query(value = "SELECT DISTINCT payment_type FROM payments",nativeQuery = true)
    List<String> findAllPaymentTypes();

}
