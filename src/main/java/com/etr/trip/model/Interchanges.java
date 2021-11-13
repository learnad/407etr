package com.etr.trip.model;

import java.util.List;


public class Interchanges {

	private String locationId;
	private String name;
	private String lat;
	private String lng;
	private List<Route> routes;
	
	
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public List<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
	@Override
	public String toString() {
		return "Interchanges [locationId=" + locationId + ", name=" + name + ", lat=" + lat + ", lng=" + lng
				+ ", routes=" + routes + "]";
	}
	
	
}
