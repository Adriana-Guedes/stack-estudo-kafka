package com.alves.strproducer.config;


import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.kafka.autoconfigure.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import java.util.HashMap;


@RequiredArgsConstructor
@Configuration
    public class KafkaAdminConfig {

        @Autowired
        private KafkaProperties properties;

        @Bean
        public KafkaAdmin kafkaAdmin() {
            var configs = new HashMap<String, Object>();
            configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
            return new KafkaAdmin(configs);
        }


        //criar um topicos(ele cria uma única vez se não existir)
    @Bean
    public KafkaAdmin.NewTopics topics(){
            return new KafkaAdmin.NewTopics(
                    TopicBuilder.name("str-topic").partitions(2).replicas(1).build()
            );

    }
    }