package com.etr.trip.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.etr.trip.config.ApplicaionConfig;
import com.etr.trip.model.TripResponse;
import com.etr.trip.service.TripCalculatorService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class TripRestController {

	private static Logger logger = LoggerFactory.getLogger(TripRestController.class);

	@Autowired
	TripCalculatorService tripCalculatorService;

	@ApiOperation(value = " calculates the cost of a vehicle driving from one point on 407ETR, to another point.", consumes = "application/text")

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Indicates successful request", response = String.class),
			@ApiResponse(code = 204, message = "No Data Available", response = String.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "point-one", required = true, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "point-one", required = true, dataType = "string", paramType = "header") })

	@RequestMapping(value = "/api/tripcalculator/v1/tripcost", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String getCostOfTrip(HttpServletRequest request) throws IllegalArgumentException {
		TripResponse tripResponse = new TripResponse();
		String pointOne = request.getHeader("point-one");
		String pointTwo = request.getHeader("point-two");
		logger.info("locationMap[{}]", ApplicaionConfig.locationAreaMap);
		if (StringUtils.isNoneBlank(pointOne) && StringUtils.isNoneBlank(pointTwo)) {
			tripResponse = tripCalculatorService.calculateCost(pointOne.trim(), pointTwo.trim());
		} else {
//			ApplicaionConfig.locationAreaMap.keySet().stream().forEach("");
			return "Invalid or empty  header parameter point-one and point-two. Please correct and try again. ";
		}
		return tripResponse.toString();
	}

}
