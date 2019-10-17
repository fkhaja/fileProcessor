package com.faisal.fileProcessor.model;

import java.util.Date;

import com.faisal.fileProcessor.util.AppUtils;
import com.univocity.parsers.annotations.Format;
import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Validate;

public class Employee {

	@Parsed(index = 0)
	@Validate
	private String firstName;

	@Parsed(index = 1)
	@Validate
	private String lastName;

	@Parsed(index = 2)
	@Format(formats = { "yyyyMMdd" }, options = "locale=en")
	@Validate
	private Date startDate;

	@Parsed(index = 3)
	private String address1;

	@Parsed(index = 4)
	private String address2;

	@Parsed(index = 5)
	private String city;

	@Parsed(index = 6)
	@NullString(nulls = { "", "empty" })
	private String state;

	@Parsed(index = 7)
	@NullString(nulls = { "", "empty" })
	private String country;

	@Parsed(index = 8)
	@NullString(nulls = { "", "empty" })
	private Integer zip;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(firstName).append(" ").append(lastName).append(", (").append(AppUtils.getFormattedDate(startDate))
				.append(")").append(AppUtils.getLineDelimiter()).append(address1).append(", ").append(address2)
				.append(",").append(AppUtils.getLineDelimiter()).append(city).append(",").append(state).append(",")
				.append(AppUtils.getLineDelimiter()).append(country).append(",").append(zip);
		return str.toString();
	}

	public void setDefaultValues() {
		if (this.state == null) {
			this.state = "CA";
		}

		if (this.country == null) {
			this.country = "USA";
		}

	}
}
