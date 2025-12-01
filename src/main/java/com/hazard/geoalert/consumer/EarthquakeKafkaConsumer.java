package com.hazard.geoalert.consumer;

import com.hazard.geoalert.model.Earthquake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class EarthquakeKafkaConsumer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "geohazard-earthquakes", groupId = "earthquake-group")
    public void consume(Earthquake earthquake){

        messagingTemplate.convertAndSend("/topic/earthquakes", earthquake);

    }

}
