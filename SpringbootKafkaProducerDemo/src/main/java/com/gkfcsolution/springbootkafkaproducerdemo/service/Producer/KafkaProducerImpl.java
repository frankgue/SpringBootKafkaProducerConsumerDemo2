package com.gkfcsolution.springbootkafkaproducerdemo.service.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 15:38
 * File: null.java
 * Project: SpringbootKafkaProducerDemo
 *
 * @author Frank GUEKENG
 * @date 05/11/2025
 * @time 15:38
 */
@Service
public class KafkaProducerImpl {
    @Value("${spring.kafka.topic.name}")
    private String TOPIC_NAME;
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String animalName){
        kafkaTemplate.send(TOPIC_NAME, animalName);
    }
}
