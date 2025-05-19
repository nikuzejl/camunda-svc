package io.camunda.getstarted.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public KafkaService(KafkaTemplate<String, String> kafkaTemplate,
                        @Value("${kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;

        publishMessage("Hello from Camunda");
    }

    public void publishMessage(String message) {
        LOGGER.info("Publishing to Kafka topic '{}': {}", topic, message);
        kafkaTemplate.send(topic, message);
    }
}
