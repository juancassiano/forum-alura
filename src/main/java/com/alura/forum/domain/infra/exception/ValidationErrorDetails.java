package com.alura.forum.domain.infra.exception;

import jakarta.validation.ConstraintViolation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorDetails{
    private String field;
    private String message;


    public static ValidationErrorDetails fromFieldError(FieldError fieldError) {
        return new ValidationErrorDetails(fieldError.getField(), fieldError.getDefaultMessage());
    }

    public static ValidationErrorDetails fromConstraintViolation(ConstraintViolation<?> constraintViolation) {
        return new ValidationErrorDetails(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
    }


}
