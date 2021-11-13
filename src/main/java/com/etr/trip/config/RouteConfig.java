package com.etr.trip.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@Component
public class RouteConfig {

	@Bean("objectMapper")
	public ObjectMapper objetMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		mapper.configOverride(List.class).setInclude(JsonInclude.Value.construct(JsonInclude.Include.NON_NULL, null));
		mapper.configOverride(Map.class).setInclude(JsonInclude.Value.construct(JsonInclude.Include.NON_NULL, null));
		return mapper;
	}
}
