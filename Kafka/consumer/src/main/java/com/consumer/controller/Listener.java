package com.consumer.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @KafkaListener(topics = AppConstants.TOPIC_NAME,
            groupId = AppConstants.GROUP_ID)
    public void updatedLocation(ConsumerRecord<String, String> record) {
        String key = record.key();
        String value = record.value();
        System.out.println("Key: " + key + ", Value: " + value);
    }
}
