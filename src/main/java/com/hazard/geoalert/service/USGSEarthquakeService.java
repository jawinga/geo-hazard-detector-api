package com.hazard.geoalert.service;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.hazard.geoalert.adapter.earthquake.EarthquakeAdapter;
import com.hazard.geoalert.dto.usgs.USGSFeature;
import com.hazard.geoalert.dto.usgs.USGSResponse;
import com.hazard.geoalert.model.Earthquake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class USGSEarthquakeService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    EarthquakeAdapter earthquakeAdapter;
    @Autowired
    private KafkaTemplate<String, Earthquake> kafkaTemplate;

    public List<Earthquake>fetchEarthquakes(){

        List<Earthquake> earthquakes = new ArrayList<>();

        LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC"));
        String isoEndDate = now.format(DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime StartDate = now.minusHours(24);
        String isoStartDate = StartDate.format(DateTimeFormatter.ISO_DATE_TIME);


        String url =  "https://earthquake.usgs.gov/fdsnws/event/1/query?" + "format=geojson&starttime=" + isoStartDate + "&endtime=" + isoEndDate;
        ResponseEntity<USGSResponse>response = restTemplate.getForEntity(url, USGSResponse.class);

        USGSResponse USGSbody = response.getBody();

        for (USGSFeature x :USGSbody.getFeatures()) {
            Earthquake earthquake = earthquakeAdapter.transformAlert(x);
            kafkaTemplate.send("geohazard-earthquakes", earthquake.getId(), earthquake);
            earthquakes.add(earthquake);
        }

        return earthquakes;



    }


}
