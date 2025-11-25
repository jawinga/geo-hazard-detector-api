package com.hazard.geoalert.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Tsunami extends Alert{
    private double waveHeight;
    private String originEarthquake;
    private int eta;
}
