package spring.employee.employeepayrole.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Gender is required")
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Start date must be in the past or today")
    private LocalDate startDate;

    @NotBlank(message = "Note is required")
    private String note;

    @NotBlank(message = "Profile picture is required")
    private String profilePic;

    @NotBlank(message = "Department is required")
    private String department;

    @Positive(message = "Salary must be positive")
    private double salary;
}