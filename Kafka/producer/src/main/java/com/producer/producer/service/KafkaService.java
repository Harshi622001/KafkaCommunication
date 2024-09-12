package com.producer.producer.service;

import com.producer.producer.constant.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;
    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateTime(String location,String value) {
        this.kafkaTemplate.send(AppConstant.TOPIC_NAME, location,value);
        this.logger.info("message produced"+location+",value:"+value);
        return true;
    }
}
