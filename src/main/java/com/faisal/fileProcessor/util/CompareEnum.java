package com.faisal.fileProcessor.util;

public enum CompareEnum {
	FIRST_NAME("firstName"), 
	LAST_NAME("lastName"), 
	START_DATE("startDate");

	private String fieldName;

	private CompareEnum(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldName() {
		return fieldName;
	}

}
