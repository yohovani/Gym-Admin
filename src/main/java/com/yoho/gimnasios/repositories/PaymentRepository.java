package com.yoho.gimnasios.repositories;

import com.yoho.gimnasios.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
