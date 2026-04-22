package com.alves.str_consumer.config;

/*
    Configuração para deserialização as mensagens e valores do kafka
 */


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

import java.util.HashMap;

@Log4j2
@RequiredArgsConstructor
@Configuration
public class StringConsumerConfig {


    private final KafkaProperties properties;


    /*
        Esse é o consumer factory para consumir os registros da outra apicação
     */

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        var configs = new HashMap<String,Object>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs);
    }


    /*
        Método para ficar "ouvindo" o topic do kafka da outra aplicaçãqo
     */

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> strcontainerFactory(
            //spring fica responsável de fazer a gestão dessa instancia
            ConsumerFactory<String, String> consumerFactory
    ){
        var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> validMessageContainerFactory(
            //spring fica responsável de fazer a gestão dessa instancia
            ConsumerFactory<String, String> consumerFactory
    ){
        var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(consumerFactory());
        factory.setRecordInterceptor(validMessage());
        return factory;
    }

    //Processamento antes do consumo listener, que valida nesse caso se existe essa palavar e TESTE
    @Bean
    public RecordInterceptor<String, String> validMessage() {
        return (record, consumer) -> {
            if(record.value().contains("Teste")){
                log.info("Possui a palavra Teste ");
            }
            return record;
        };
    }

}
