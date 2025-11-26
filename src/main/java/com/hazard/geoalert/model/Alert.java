package com.hazard.geoalert.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class Alert {
    private String id;
    private String type;
    private int severity;
    private LocalDateTime time;
    private String location;
    private String description;
    private String specificSeverity;


}