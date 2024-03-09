package com.adm.pharmacy.models.enums;

public enum Way {
	// way = via
	ORAL(1),
	NASAL(2),
	VENOUS(3),
	INTRAMUSCULAR(4),
	RECTAL(5);
	
	private int code;
	
	private Way(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Way valueOf(int code) {
		for(Way value: Way.values()) {
			if(value.getCode() == code) {
				return value;
			}			
		}
		throw new IllegalArgumentException("Invalid way code.");
	}
}
