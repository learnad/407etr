package com.etr.trip.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;

import com.etr.trip.model.Point;

@Configuration
public class ApplicaionConfig {

	public static Map<String, Point> locationAreaMap = new HashMap<>(50);

}
