package spring.employee.employeepayrole.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double salary;
    private String email;
    private String department;

    public Employee(String name, double salary, String email, String department) {
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.department = department;
    }
}
