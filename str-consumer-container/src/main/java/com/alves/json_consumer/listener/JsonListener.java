package com.alves.json_consumer.listener;


import com.alves.json_consumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;


@Log4j2
@Component
public class JsonListener {



    /* ========== PRIMEIRO CONSUMER ===================*/
    @SneakyThrows //ignorar tratamento
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload String message ){
        log.info("Recebi o pagamento {}", message);
        sleep(2000);
        log.info("Validando fraude...");
        sleep(2000);
        log.info("Compra aprovada ...");
        sleep(2000);
    }


    /* ========== SEGUNDO CONSUMER ===================*/
    @SneakyThrows //ignorar tratamento
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload String message){
        log.info("Gerando PDF do produto de id {}...", message);
        sleep(2000);
    }


    /* ========== TERCEIRO CONSUMER ===================*/
    @SneakyThrows //ignorar tratamento
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(){
        log.info("Enviando email de confirmação...");
        sleep(3000);
    }
}
