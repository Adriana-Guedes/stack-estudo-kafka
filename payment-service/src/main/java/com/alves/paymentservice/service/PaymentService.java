package com.alves.paymentservice.service;
import com.alves.paymentservice.model.Payment;



public interface PaymentService {
    void sendPayment (Payment payment);
}
