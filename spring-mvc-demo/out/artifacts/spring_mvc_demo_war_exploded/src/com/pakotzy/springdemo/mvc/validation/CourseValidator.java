package com.pakotzy.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseValidator implements ConstraintValidator<Course, String> {
	private String rule;

	@Override
	public void initialize(Course constraintAnnotation) {
		rule = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		if (s != null) {
			return s.startsWith(rule);
		} else {
			return true;
		}
	}
}
