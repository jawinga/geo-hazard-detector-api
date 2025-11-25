package com.hazard.geoalert.dto.usgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class USGSProperties {
    private double mag;
    private String place;
    private long time;
    private String magType;
    private String title;
    private String type;

}
