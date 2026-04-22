# 📦 stack-estudo-kafka 
**Udemy Business – Prof. Valdir Cezar**

Stack de estudo para Apache Kafka utilizando Docker e Spring Boot, com foco em comunicação assíncrona.
---

## 🎯 Objetivo
Este projeto tem como objetivo estudar e praticar:

- Apache Kafka em ambiente local  
- Comunicação entre **producers** e **consumers**  
- Execução de aplicações localmente e em containers  
- Configuração correta de **listeners**, **ports** e **advertised.listeners**  
- Tratamento de erros no consumer  
- Concorrência e paralelismo  
- Debug realista de problemas comuns em **Kafka + Docker**

---

## 🧱 Tecnologias Utilizadas

### Infraestrutura
- Docker  
- Docker Compose  
- Apache Kafka  
- Zookeeper  
- Kafdrop (UI para inspeção de tópicos)


### Backend
- Java  
- Spring Boot  
- Spring Kafka  
- Jackson (JSON)

---

## 🧩 Arquitetura da Stack

### Kafka
- Listener interno para containers: `kafka:29092`  
- Listener externo para host: `localhost:9092`  
- Network Docker dedicada


### Producer
- Envio de mensagens JSON  
- Configuração via variável de ambiente


### Consumer
- Consumo de mensagens Kafka  
- Processamento concorrente  
- Tratamento de erros customizado



Kafdrop
- Visualização de tópicos, partitions e mensagens



