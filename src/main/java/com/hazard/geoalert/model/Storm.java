package com.hazard.geoalert.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Storm extends Alert {
    private String stormType;
    private String specificSeverity;
    private double windSpeed;
    private double pressure;
}