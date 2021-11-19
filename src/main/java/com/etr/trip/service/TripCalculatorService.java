package com.etr.trip.service;

import java.text.DecimalFormat;

import org.apache.lucene.util.SloppyMath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.etr.trip.config.ApplicaionConfig;
import com.etr.trip.controller.TripRestController;
import com.etr.trip.model.Point;
import com.etr.trip.model.TripResponse;

@Component
public class TripCalculatorService {

	private static Logger logger = LoggerFactory.getLogger(TripRestController.class);
	private static final DecimalFormat df = new DecimalFormat("0.00");

	public TripResponse calculateCost(String pointOne, String pointTwo) {
		TripResponse response = new TripResponse();
		if (ApplicaionConfig.locationAreaMap.containsKey(pointOne)
				&& ApplicaionConfig.locationAreaMap.containsKey(pointTwo)) {
			Point p1 = findAreaDetail(pointOne);
			logger.info("pointOne[{}]", p1);
			Point p2 = findAreaDetail(pointTwo);
			logger.info("toPoint[{}]", p2);

			double distance = SloppyMath.haversinMeters(p1.getLat(), p1.getLng(), p2.getLat(), p2.getLng()) / 1000d;
			logger.info("distance is [{}] K.M ", distance);
			double cost = (distance * 0.25d);
			logger.info("cost is [{}]  ", cost);
			response.setDistance(df.format(distance));
			response.setCost(df.format(cost));
		}
		return response;
	}

	private Point findAreaDetail(String name) {
		return ApplicaionConfig.locationAreaMap.get(name);
	}
}
