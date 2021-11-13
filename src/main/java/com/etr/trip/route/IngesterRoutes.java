package com.etr.trip.route;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.etr.trip.service.FileInjestorService;

@Component
public class IngesterRoutes extends RouteBuilder {

	private static Logger logger = LoggerFactory.getLogger(IngesterRoutes.class);
	private static final String URI_ENDPOINT_TO_FILEINJESTOR = "file:toIngestor";

	@Autowired
	FileInjestorService fileInjestorService;

	@Override
	public void configure() throws Exception {
		addFileIngestoryRoute();
	}

	// Look up for File (new interchanges.json)
	private void addFileIngestoryRoute() {
		logger.info("Init");
		from(URI_ENDPOINT_TO_FILEINJESTOR).process(fileInjestorService);
	}

}
