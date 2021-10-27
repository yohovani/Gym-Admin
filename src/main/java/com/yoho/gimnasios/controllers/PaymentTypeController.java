package com.yoho.gimnasios.controllers;

import com.yoho.gimnasios.models.PaymentType;
import com.yoho.gimnasios.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "paymentType")
public class PaymentTypeController {
    private final PaymentTypeService paymentTypeService;

    @Autowired
    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @PostMapping(path = "/addPaymentType")
    public PaymentType addPaymentType(@RequestBody PaymentType paymentType){
        return this.paymentTypeService.addPaymentType(paymentType.getType());
    }
}
