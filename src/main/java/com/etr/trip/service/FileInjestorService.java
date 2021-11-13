package com.etr.trip.service;

import java.io.FileReader;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.stream.JsonReader;

@Component
public class FileInjestorService implements Processor {
	private static Logger logger = LoggerFactory.getLogger(FileInjestorService.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("process started.");
		//convert json to POJO
		JsonReader reader = new JsonReader(new FileReader("./src/main/resources/interchanges.json"));
		
	}

}
