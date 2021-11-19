package com.etr.trip.route;

import java.io.File;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etr.trip.service.FileInjestorService;

@Component
public class IngesterRoutes extends RouteBuilder {

	private static Logger logger = LoggerFactory.getLogger(IngesterRoutes.class);

	@Autowired
	FileInjestorService fileInjestorService;

	@Override
	public void configure() throws Exception {
		addFileIngestoryRoute();
	}

	// Look up for File (new interchanges.json)
	private void addFileIngestoryRoute() {
		logger.info("inside IngesterRoutes..");
		from("file:files/input/?noop=true").convertBodyTo(File.class).process(new FileInjestorService());
	}

}
