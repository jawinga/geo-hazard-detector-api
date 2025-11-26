package com.hazard.geoalert.adapter.earthquake;
import java.util.List;
import com.hazard.geoalert.dto.usgs.USGSFeature;
import com.hazard.geoalert.model.Earthquake;
import java.time.Instant;
import java.time.ZoneId;
import java.time.LocalDateTime;

public class EarthquakeAdapter {

    public Earthquake transformAlert(USGSFeature features){

        Earthquake alert = new Earthquake();
        alert.setId(Integer.parseInt(features.getId()));
        alert.setSeverity(calculateSeverity(features.getProperties().getMag()));
        alert.setTitle(features.getProperties().getTitle());
        alert.setType("earthquake");
        alert.setMagnitude(features.getProperties().getMag());
        alert.setLocation(features.getProperties().getPlace());
        alert.setDepth(extractDepth(features.getGeometry().getCoordinates()));
        alert.setTime(convertTimestamp(features.getProperties().getTime()));
        alert.setCoordinates(formatCoordinates(features.getGeometry().getCoordinates()));
        return alert;

    }


    private int calculateSeverity(double magnitude) {
        if (magnitude >= 7.0) {
            return 1;
        } else if (magnitude >= 5.0) {
            return 2;
        } else if (magnitude >= 3.0) {
            return 3;
        } else {
            return 4;
        }
    }

    private double extractDepth(List<Double>coordinates){

        if(coordinates.size() > 2){

            return coordinates.get(coordinates.size() -1);

        }
        return 0.0;

    }
    private String formatCoordinates(List<Double> coordinates) {
        double longitude = coordinates.get(0);
        double latitude = coordinates.get(1);
        return latitude + "," + longitude;
    }
    private LocalDateTime convertTimestamp(long milliseconds) {
        return Instant.ofEpochMilli(milliseconds)
                .atZone(ZoneId.of("UTC"))
                .toLocalDateTime();
    }

}
