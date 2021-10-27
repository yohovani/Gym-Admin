package com.yoho.gimnasios.services;

import com.yoho.gimnasios.models.PaymentType;
import com.yoho.gimnasios.repositories.PaymentRepository;
import com.yoho.gimnasios.repositories.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentTypeService {
    private final PaymentTypeRepository paymentTypeRepository;

    @Autowired
    public PaymentTypeService(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    public PaymentType addPaymentType(String type){
        PaymentType paymentType = new PaymentType(type);
        if(!this.validateDuplicateType(type))
            this.paymentTypeRepository.save(paymentType);
        else
            paymentType = new PaymentType("Tipo de pago duplicado");
        return paymentType;
    }

    public Boolean validateDuplicateType(String type){
        Optional<PaymentType> pt = this.paymentTypeRepository.searchDuplicate(type);
        //If pt.empty is true then the type doesn't exists and return false to indicate this
        //If pt.empty is false then the type exists and return true to indicate this
        return !pt.isEmpty();
    }
}
