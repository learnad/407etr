package com.etr.trip.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.etr.trip.model.Interchanges;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ApplicaionConfig {

	private static Logger logger = LoggerFactory.getLogger(ApplicaionConfig.class);

	private String env;
	
	@Autowired
	ObjectMapper objectMapper;

	@PostConstruct
	public Map<String, Interchanges> populateJsonMap() throws JsonParseException, JsonMappingException, IOException {
		logger.info("populateJsonMap started..");
//		Resource resource = new ClassPathResource("src/main/resources/interchanges.json");
//			JsonReader reader = new JsonReader(new FileReader("interchanges.json"));
		
		objectMapper.readValue(new File("src/main/resources/interchanges.json"), Interchanges.class);
		return null;

	}

}
