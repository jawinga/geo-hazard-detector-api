package com.hazard.geoalert;
import static org.junit.jupiter.api.Assertions.*;
import com.hazard.geoalert.model.Earthquake;
import com.hazard.geoalert.service.USGSEarthquakeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GeoHazardAlertApiApplicationTests {

	@Autowired
	USGSEarthquakeService usgsEarthquakeService;


	@Test
	void contextLoads() {
	}

	@Test
	void testFetchEarthquakes(){
		List<Earthquake> earthquakes = usgsEarthquakeService.fetchEarthquakes();
		assertNotNull(earthquakes.get(0).getLocation());
		assertEquals("earthquake", earthquakes.get(0).getType());
		assertNotNull(earthquakes);
	}

}
