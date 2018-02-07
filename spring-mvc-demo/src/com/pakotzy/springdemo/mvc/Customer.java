package com.pakotzy.springdemo.mvc;

import com.pakotzy.springdemo.mvc.validation.Course;

import javax.validation.constraints.*;

public class Customer {
	private String firstName;

	@NotNull(message = "required")
	@Size(min = 1, message = "required")
	private String lastName;

	@Min(value = 0)
	@Max(value = 10)
	private Integer freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}")
	private String postalCode;

	@Course
	private String courseCode;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

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
}
