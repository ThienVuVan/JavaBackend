package fa.training.test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;


import fa.training.entities.Employee;

import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationTest {
	public static void main(String[] args) {
		// Create ValidatorFactory which returns validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        
        // It validates bean instances
        Validator validator = factory.getValidator();
        
        Employee employee = new Employee("Thien", "w", "abc@gmail.com", "123456789y", 1234d, "https://asd.com");
        
        // Validate bean
        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        
        // Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<Employee> violation : constraintViolations) {
                System.out.println(violation.getMessage());
            }
        } else {
            System.out.println("Valid Object");
        }
	}
}
