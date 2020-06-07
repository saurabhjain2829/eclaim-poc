package com.nagarro.eclaim.constants;

public enum TimeUnitType {

	HOUR("HOUR"), MINUTE("MINUTE");
	private String type;

	private TimeUnitType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
