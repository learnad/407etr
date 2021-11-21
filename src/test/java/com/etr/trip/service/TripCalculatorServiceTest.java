package com.etr.trip.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import com.etr.trip.model.Point;
import com.etr.trip.model.TripResponse;

public class TripCalculatorServiceTest {

	private TripCalculatorService tripCalculatorService = new TripCalculatorService();

	@BeforeEach
	void testConfigure() throws Exception {
		File resource = new ClassPathResource("interchanges.json").getFile();
		FileInjestorService fileInjestorService = new FileInjestorService();
		fileInjestorService.processBody(resource);
	}

	@Test
	public void givenNotNullHeader_whenAssertingEquality_thenEqual() {
		TripResponse response = tripCalculatorService.calculateCost("QEW", "Dundas Street");
		assertNotNull(response);
	}

	@Test
	public void givenInValidHeader_whenAssertingEquality_thenEqual() {
		TripResponse response = tripCalculatorService.calculateCost("QEWee", "Dundas Street22");
		assertEquals("-1", response.getDistance());
	}

	@Test
	public void givenNullPoint_whenAssertingEquality_thenEqual() {
		Point response = tripCalculatorService.findPointDetail(null);
		assertNull(response);
	}
}
