package spring.employee.employeepayrole.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NotBlank(message = "Name is required and cannot be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z ]{2,}$", message = "Name must start with a capital letter and contain only letters and spaces")
    private String name;

    @Min(value = 1000, message = "Salary must be greater than 1000")
    private double salary;

    @Email(message = "Invalid email format")
    private String email;

    private String department;
}