/**
 * 
 */
package com.formanotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.stereotype.Controller;

@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD})
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
	String message() default"{phone}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[]  payload() default {};;
}
