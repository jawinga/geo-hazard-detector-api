package com.hazard.geoalert.dto.usgs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class USGSResponse {
    private List<USGSFeature> features;
}