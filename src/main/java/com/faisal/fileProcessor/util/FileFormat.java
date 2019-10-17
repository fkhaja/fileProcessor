package com.faisal.fileProcessor.util;

public enum FileFormat {
	FIXED("1"),
	CSV("2");
	
	private String headerValue;
	
	private FileFormat(String headerValue) {
		this.headerValue = headerValue;
	}
	
	public String getHeaderValue() {
		return headerValue;
	}
}
