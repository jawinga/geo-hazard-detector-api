package com.hazard.geoalert.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.admin.NewTopic;


@Configuration
public class EarthquakeKafkaConfig {


    @Bean
    public NewTopic earthquakeTopic() {
        return new NewTopic("geohazard-earthquakes", 1, (short) 1);
    }
}
