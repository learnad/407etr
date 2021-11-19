package com.etr.trip.model;

public class TripResponse {

	private String distance;
	private String cost;

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Distance:=");
		builder.append(distance+" km");
		builder.append("\nCost:=$");
		builder.append(cost);
		return builder.toString();
	}

}
