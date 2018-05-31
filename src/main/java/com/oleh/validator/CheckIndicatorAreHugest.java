package com.oleh.validator;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = CheckIndicatorAreHugestValidator.class)
public @interface CheckIndicatorAreHugest {
	String message() default "User more hugest indicator";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
