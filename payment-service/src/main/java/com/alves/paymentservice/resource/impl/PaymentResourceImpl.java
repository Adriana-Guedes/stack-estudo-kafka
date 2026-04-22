package com.alves.paymentservice.resource.impl;

import com.alves.paymentservice.model.Payment;
import com.alves.paymentservice.resource.PaymentResource;
import com.alves.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor // lombok vai injetar instancia do service no construtor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
        //sem banco de dado não será retornado valor que deveria ser salvo la
    }
}
