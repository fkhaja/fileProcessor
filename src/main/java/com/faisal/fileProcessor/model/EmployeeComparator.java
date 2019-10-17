package com.faisal.fileProcessor.model;

import java.util.Comparator;

import com.faisal.fileProcessor.util.CompareEnum;

public class EmployeeComparator implements Comparator<Employee> {

	private final String type;

	public EmployeeComparator(String type) {
		this.type = type;
	}

	public int compare(Employee e1, Employee e2) {
		if (type.equals(CompareEnum.FIRST_NAME.getFieldName())) {	
			return e1.getFirstName().compareTo(e2.getFirstName());
		} else if (type.equals(CompareEnum.LAST_NAME.getFieldName())) {
			return e1.getLastName().compareTo(e2.getLastName());
		} else if (type.equals(CompareEnum.START_DATE.getFieldName())) {
			return e1.getStartDate().compareTo(e2.getStartDate());
		}
		return e1.getFirstName().compareTo(e2.getFirstName());
	}

}
