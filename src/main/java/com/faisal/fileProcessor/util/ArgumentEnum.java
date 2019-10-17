package com.faisal.fileProcessor.util;

public enum ArgumentEnum {
	INPUT_FILE("inputFile"), SORT_BY("sortBy");

	private String argument;

	private ArgumentEnum(String argument) {
		this.argument = argument;
	}

	public String getArgument() {
		return argument;
	}
}
