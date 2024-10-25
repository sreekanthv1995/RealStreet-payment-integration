package com.realstreet_payment_integration.realstreet.service;

import com.realstreet_payment_integration.realstreet.dto.PaymentRequest;
import com.realstreet_payment_integration.realstreet.dto.PaymentResponse;
import com.realstreet_payment_integration.realstreet.model.Payment;
import com.realstreet_payment_integration.realstreet.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {

    private final CreditCardService creditCardService;
    private final DebitCardService debitCardService;
    private final NetBankingService netBankingService;
    private final UPIService upiService;
    private final TransactionRepository transactionRepository;

    public PaymentResponse createTransaction(String paymentType, PaymentRequest paymentRequest){
        Payment payment = null;
        switch (paymentType) {
            case "UPI" -> payment = upiService.createUpiPayment(paymentRequest);
            case "CreditCard" -> payment = creditCardService.createCreditCardPayment(paymentRequest);
            case "DebitCard" -> payment = debitCardService.createDebitCardPayment(paymentRequest);
            case "NetBanking" -> payment = netBankingService.createNetBankingPayment(paymentRequest);
            default -> {
                PaymentResponse paymentResponse = new PaymentResponse();
                paymentResponse.setMessage("Invalid Payment Type");
                return paymentResponse;
            }
        }
        transactionRepository.save(payment);
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setMessage("Payment created successfully");
        return paymentResponse;
    }

    public List<String> getAllPaymentMethods(){
        return transactionRepository.findAllPaymentTypes();
    }

    public List<Payment>getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Payment getTransactionById(Long id){
        Optional<Payment> optionalPayment = transactionRepository.findById(id);
        if (optionalPayment.isPresent()){
            return optionalPayment.get();
        }else {
            throw new EntityNotFoundException("Not Found");
        }

    }

}
