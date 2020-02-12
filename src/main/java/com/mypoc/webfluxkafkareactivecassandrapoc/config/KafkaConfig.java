package com.mypoc.webfluxkafkareactivecassandrapoc.config;

import com.mypoc.webfluxkafkareactivecassandrapoc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConfig.class);;
    private final String clientId;
    private final String bootStrapServers;
    private final String keySerializer;
    private final String valueSerializer;
    private final String ackSetting;
    public KafkaConfig(@Value("${spring.kafka.producer.client-id}") String clientId,
                       @Value("${spring.kafka.producer.bootstrap-servers}") String bootStrapServers,
                       @Value("${spring.kafka.producer.key-serializer}") String keySerializer,
                       @Value("${spring.kafka.producer.value-serializer}") String valueSerializer,
                       @Value("${spring.kafka.producer.ack-setting}") String ackSetting) {
        this.clientId = clientId;
        this.bootStrapServers = bootStrapServers;
        this.keySerializer = keySerializer;
        this.valueSerializer = valueSerializer;
        this.ackSetting = ackSetting;
    }
    @Bean
    public ProducerFactory<String, User> getKafkaProducerFactory() {
        LOGGER.info("Initializing Kafka Producer");
        Map<String, Object> properties = new HashMap<>();
        properties.put("client.id", clientId);
        properties.put("bootstrap.servers", bootStrapServers);
        properties.put("acks", ackSetting);
        properties.put("key.serializer", keySerializer);
        properties.put("value.serializer", valueSerializer);
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, User> kafkaTemplate(){
        return new KafkaTemplate<>(getKafkaProducerFactory());
    }
}
