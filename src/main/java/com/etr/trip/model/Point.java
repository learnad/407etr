package com.etr.trip.model;

import java.util.List;

public class Point {
	
	private String name;
	
	private double lat;
	
	private double lng;
	
	private String devcomment;
	
	private List<Route> routes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getDevcomment() {
		return devcomment;
	}

	public void setDevcomment(String devcomment) {
		this.devcomment = devcomment;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Point [name=").append(name).append(", lat=").append(lat).append(", lng=").append(lng)
				.append(", devcomment=").append(devcomment).append(", routes=").append(routes).append("]");
		return builder.toString();
	}

	
	
}
