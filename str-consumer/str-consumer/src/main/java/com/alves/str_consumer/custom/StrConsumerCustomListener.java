package com.alves.str_consumer.custom;



/*
    Uma annotation manual como por ex: @Entity, @Data, etc
 */

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//deve estar disponivel em tempo de execução
@Target(ElementType.METHOD)
@KafkaListener
public @interface StrConsumerCustomListener {


    @AliasFor(annotation = KafkaListener.class, attribute = "topics" )
    String[] topics() default "str-topic"; //esse topico será o padrão

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory" )
    String containerFactory() default "strcontainerFactory";//esse container será o padrão

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId" )
    String groupId() default " "; //a ser definido

    @AliasFor(annotation = KafkaListener.class, attribute = "errorHandler" )
    String errorHandler() default "errorCustomHandler";

}
