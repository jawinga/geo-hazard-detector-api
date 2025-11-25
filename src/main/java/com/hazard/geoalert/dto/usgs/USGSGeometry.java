package com.hazard.geoalert.dto.usgs;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class USGSGeometry {
    private List<Double> coordinates;


}
