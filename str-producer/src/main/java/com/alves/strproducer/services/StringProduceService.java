package com.alves.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class StringProduceService {

    private final KafkaTemplate<String,String> kafkaTemplate;


    public void sendMessage(String message){
        log.info("Enviando Mensagem {}", message);
        kafkaTemplate.send("str-topic", message);

                /*
                .whenComplete((sucess, ex) -> { //aqui chama o callback
                    if (sucess != null) {
                            log.info("\nMensagem enviada com sucesso " + message //mensagem enviada com sucesso
                                    +", Partition: "
                                    + sucess.getRecordMetadata().partition() +   // saber qual partition
                                    ", Offset: "
                                    + sucess.getRecordMetadata().offset() +"\n") ; // saber qual offset
                    } else {

                          log.info("Erro ao enviar mensagem: " + ex.getMessage());

                    }
                });

                 */

    }




}
