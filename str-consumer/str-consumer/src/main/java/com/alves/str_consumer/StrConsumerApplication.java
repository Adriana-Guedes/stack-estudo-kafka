package com.alves.str_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;


@EnableKafka //habilitação do kafka
@SpringBootApplication
public class StrConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrConsumerApplication.class, args);
	}

}
