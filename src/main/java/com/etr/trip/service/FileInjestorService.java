package com.etr.trip.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etr.trip.config.ApplicaionConfig;
import com.etr.trip.model.Point;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class FileInjestorService implements Processor {
	private static Logger logger = LoggerFactory.getLogger(FileInjestorService.class);

	@Autowired
	ApplicaionConfig applicaionConfig;

	@Override
	public void process(Exchange exchange) throws Exception {
		Object body = exchange.getIn().getBody();
		processBody(body);
	}

	@SuppressWarnings("unchecked")
	public void processBody(Object body) {
		logger.info("file processing started...[{}]", body);
		try (InputStream inputStream = new FileInputStream(body.toString());
				Reader reader = new InputStreamReader(inputStream);) {

			Object fileObject = new JSONParser().parse(reader);

			JSONObject rootElement = (JSONObject) fileObject;

			JSONObject locationsObject = (JSONObject) rootElement.get("locations");
			logger.info("locations[{}]", locationsObject.size());
			// get iterator over map...
			Iterator<JSONObject> locationIterator = locationsObject.keySet().iterator();
			while (locationIterator.hasNext()) {
				// grab a key
				Object object = locationIterator.next();
				String key = object.toString();
				// grab a value
				String value = locationsObject.get(key).toString();
				ObjectMapper mapper = new ObjectMapper();
				Point area = mapper.readValue(value, Point.class);
				// fill map
				ApplicaionConfig.locationAreaMap.put(area.getName(), area);
			}
		} catch (Exception e) {
			logger.error("error occured...");
			e.printStackTrace();
		}
	}

}
