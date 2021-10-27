package com.yoho.gimnasios.services;

import com.yoho.gimnasios.models.Payment;
import com.yoho.gimnasios.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment savePayment(Payment payment){
        this.paymentRepository.save(payment);
        return payment;
    }

    public String deletePayment(Long id){
        this.paymentRepository.deleteById(id);
        return "ok";
    }



}
