package com.etr.trip.model;

import java.math.BigDecimal;

public class Route {
	
	private String toId;

	private BigDecimal distance;
	
	private boolean enter;
	
	private boolean exit;
	
	private String startDate;

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public BigDecimal getDistance() {
		return distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}

	public boolean isEnter() {
		return enter;
	}

	public void setEnter(boolean enter) {
		this.enter = enter;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Route [toId=");
		builder.append(toId);
		builder.append(", distance=");
		builder.append(distance);
		builder.append(", enter=");
		builder.append(enter);
		builder.append(", exit=");
		builder.append(exit);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
