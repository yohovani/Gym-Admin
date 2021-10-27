package com.yoho.gimnasios.controllers;

import com.yoho.gimnasios.models.Payment;
import com.yoho.gimnasios.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "payments")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/addPayment")
    public Payment addPayment(@RequestBody Payment payment){
        Payment payment_save = new Payment(payment.getMonto());
        payment_save.setPaymentType(payment.getPaymentType());
        return this.paymentService.savePayment(payment_save);
    }

    @PutMapping(path = "/deletePayment/{idPayment}")
    public String deletePayment(@PathVariable("idPayment") Long idPayment){
        if(this.paymentService.deletePayment(idPayment).equals("ok"))
            return "{'message':'pago con id "+idPayment+" eliminado'}";
        else{
            return "{'message':'Error";
        }
    }
}
