package com.alves.paymentservice.service.impl;

import com.alves.paymentservice.model.Payment;
import com.alves.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;


@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {


    private final KafkaTemplate<String, String> kafkaTemplate;

    @SneakyThrows //para fazer tratamento de exceções
    @Override
    public void sendPayment(Payment payment) {
       log.info("Recebi o pagamento {}", payment);
       Thread.sleep(1000);

       log.info("Enviando Pagamento ...");
        String json =  new ObjectMapper().writeValueAsString(payment);
       kafkaTemplate.send("payment-topic", json);

    }
}
