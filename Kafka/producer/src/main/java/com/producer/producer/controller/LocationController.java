package com.producer.producer.controller;

import com.producer.producer.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private KafkaService kafkaservice;
    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        String key="key";
        String message="("+Math.round(Math.round(Math.random())*100)+","+Math.round(Math.round(Math.random()))*100;
         this.kafkaservice.updateTime(key,message);
        return new ResponseEntity<>(Map.of(),HttpStatusCode.valueOf(200));

    }

}
