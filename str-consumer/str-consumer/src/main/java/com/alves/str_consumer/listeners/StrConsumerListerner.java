package com.alves.str_consumer.listeners;


import com.alves.str_consumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Log4j2
@Component
public class StrConsumerListerner {



    /*
        chmando o containerFactory da Classe StringConsumerConfig
        Para colocar listeners é necessário ter partições suficientes,
        pois cada partição só pode receber uma assinatura de listener
        Com grupos diferentes do mesmo topic escutam as mesmas mensagens
     */

    //@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strcontainerFactory") //
    //substituido por uma annotation criada manualmente  @StrConsumerCustomListtener


    @SneakyThrows //essa notação é do lombock
    @StrConsumerCustomListener(groupId = "group-1" ) //annotation manual criada
    public void create (String message){
        log.info("CREATE: Rebecer Mensagem {}", message);
        throw new IllegalAccessException("EXCEPTION...");
    }

    @StrConsumerCustomListener(groupId = "group-1" )
    public void log (String message){
        log.info("LOG: Rebecer Mensagem {}", message);
    }


    //utiliza o container factory de validação (este não mais costumezado como os de cima, precisa configurar as demais informações)
    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history (String message){
        log.info("HISTORY: Rebecer Mensagem {}", message);
    }
}
