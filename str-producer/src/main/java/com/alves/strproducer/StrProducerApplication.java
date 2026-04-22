package com.alves.strproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 /*
    Microservice de mensageria
    esse serviço vai produzir mensagem do tipo "string"
  */
@SpringBootApplication
public class StrProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrProducerApplication.class, args);
	}

}
