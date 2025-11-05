package com.gkfcsolution.springbootkafkaconsumerdemo.service.Consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 16:47
 * File: null.java
 * Project: SpringbootKafkaConsumerDemo
 *
 * @author Frank GUEKENG
 * @date 05/11/2025
 * @time 16:47
 */
@Service
@Slf4j
public class KafkaConsumerImpl {

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void listen(String animalName){
      log.info("Received {} from AnimmalTopic.", animalName);
    }
}
