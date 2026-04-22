package com.alves.strproducer.resources;


import com.alves.strproducer.services.StringProduceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
    Enpoint para enviar uma mensagem
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class StringProducerResource {

    private final StringProduceService produceService;


    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
        produceService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();


    }

}
