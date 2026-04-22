package com.alves.paymentservice.config;


import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import tools.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;


@RequiredArgsConstructor
@Configuration
public class JsonProducerConfig {


    private final KafkaProperties properties;

    @Bean
    public ProducerFactory jsonProducerFactory(){
        var configs = new HashMap<String, Object>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory(configs, new StringSerializer(), new StringSerializer());

    }


    @Bean
    public KafkaTemplate<String, String> jsonKafkaTemplate(ProducerFactory jsonProducerFactory){
        return new KafkaTemplate<>(jsonProducerFactory);
    }
}
