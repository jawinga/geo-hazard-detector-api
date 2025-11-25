package com.hazard.geoalert.dto.usgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class USGSFeature {

    private String id;
    private USGSProperties properties;
    private USGSGeometry geometry;
}
