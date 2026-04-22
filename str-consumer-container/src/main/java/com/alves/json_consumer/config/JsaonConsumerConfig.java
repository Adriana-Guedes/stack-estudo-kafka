package com.alves.json_consumer.config;


import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


import java.util.HashMap;

//Listener para ouvir as mensagens que vão chegar no topico kafka


@RequiredArgsConstructor
@Configuration
public class JsaonConsumerConfig {



    private final KafkaProperties properties;


    @Bean
    public ConsumerFactory<String, String> jsonConsumerFactory(){
        var configs = new HashMap<String, Object>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs);
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory jsonContainerFactory(ConsumerFactory<String, String> jsonConsumerFactory){
        var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        factory.setConsumerFactory(jsonConsumerFactory);
        return factory;
    }


}
