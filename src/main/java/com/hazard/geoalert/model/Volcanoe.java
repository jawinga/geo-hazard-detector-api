package com.hazard.geoalert.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Volcanoe extends Alert{

    private String eruptionType;
    private double ashHeight;

}