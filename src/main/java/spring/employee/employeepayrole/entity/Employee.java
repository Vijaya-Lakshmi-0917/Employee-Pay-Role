package spring.employee.employeepayrole.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String department;
    private double salary;
    private String email;
}
