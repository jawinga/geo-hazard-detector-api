package com.hazard.geoalert.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Earthquake extends Alert{

    private double magnitude;
    private double depth;
    private String coordinates;
    private String title;

}