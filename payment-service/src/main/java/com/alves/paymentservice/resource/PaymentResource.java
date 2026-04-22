package com.alves.paymentservice.resource;

import com.alves.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




public interface PaymentResource {
    //ideal é retornar um dto
    @PostMapping
    ResponseEntity<Payment> payment(@RequestBody Payment payment);
}
