package com.pakotzy.springdemo.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Course {
	public String value() default "LUV";

	public String message() default "course must start with LUV";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}
