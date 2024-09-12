package com.producer.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody String message) {
        String key = "name";
        kafkaTemplate.send("my-topic", key, message);
        System.out.println("Message Produced :key- " + key + " value- " + message);
        return "Message sent to Kafka!";
    }
}
