package spring.employee.employeepayrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.employee.employeepayrole.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}