package com.hazard.geoalert.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flood {
    private double waterLevel;
    private String floodStage;
    private String affectedArea;
}
