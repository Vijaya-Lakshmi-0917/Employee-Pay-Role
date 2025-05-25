package spring.employee.employeepayrole.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class User {

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Name must start with a capital letter and be at least 3 characters long")
    private String name;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @NotNull(message = "Start date is mandatory")
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Start date must be a past or present date")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be blank")
    private String note;

    @NotBlank(message = "Profile pic is required")
    private String profilePic;

    @NotEmpty(message = "Department must not be empty")
    private List<String> department;

    @Min(value = 1000, message = "Salary must be at least 1000")
    private long salary;
}