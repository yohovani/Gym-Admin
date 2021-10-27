package com.yoho.gimnasios.repositories;

import com.yoho.gimnasios.models.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {

    @Query("SELECT pt FROM tipos_pago pt WHERE pt.type = ?1")
    Optional<PaymentType> searchDuplicate(String type);
}
