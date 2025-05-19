package io.camunda.getstarted.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}")
    void listener(String data){
        LOGGER.info("Listener received - {} ", data);
    }
}
