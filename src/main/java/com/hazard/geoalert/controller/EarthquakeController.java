package com.hazard.geoalert.controller;

import com.hazard.geoalert.model.Earthquake;
import com.hazard.geoalert.service.USGSEarthquakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EarthquakeController {

    @Autowired
    private USGSEarthquakeService usgsEarthquakeService;

    @GetMapping("/earthquakes")
    public List<Earthquake> fetchEarthquakes(){

        return usgsEarthquakeService.fetchEarthquakes();

    }


}
