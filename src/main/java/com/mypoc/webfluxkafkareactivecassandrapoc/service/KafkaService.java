package com.mypoc.webfluxkafkareactivecassandrapoc.service;

import com.mypoc.webfluxkafkareactivecassandrapoc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class KafkaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    @Value("${spring.kafka.producer.topic-name}")
    private String kafkaTopic;

    public void sendDataToKafkaTopic(User userData) throws ExecutionException, InterruptedException {
        LOGGER.info("Sending data to Kafka Topic...");
        kafkaTemplate.send(kafkaTopic,"userData",userData);
        LOGGER.info("sent data to topic");
    }
}
