package com.etr.trip.model;

public class Route {
	
	private String toId;
	
	private String distance;
	
	private String startDate;

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "routes [toId=" + toId + ", distance=" + distance + ", startDate=" + startDate + "]";
	}
	
	
}
