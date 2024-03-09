package com.adm.pharmacy.models.enums;

public enum Laboratory {
	PFIZER(1),
	MEDLEY(2);
	
	private int code;
	
	private Laboratory(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Laboratory valueOf(int code) {
		for(Laboratory value: Laboratory.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid laboratory code.");
	}
}
