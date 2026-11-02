package com.example.employeeapi.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record EmployeeRequest(

        @NotBlank(message = "First name is required")
        @Size(max = 50, message = "First name must be at most 50 characters")
        String firstName,

        @NotBlank(message = "Last name is required")
        @Size(max = 50, message = "Last name must be at most 50 characters")
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be a valid email address")
        String email,

        @NotBlank(message = "Department is required")
        @Size(max = 50, message = "Department must be at most 50 characters")
        String department,

        @NotNull(message = "Salary is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
        @Digits(integer = 10, fraction = 2, message = "Salary can have at most 2 decimal places")
        BigDecimal salary
) { }