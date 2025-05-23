package spring.employee.employeepayrole.repository;

import spring.employee.employeepayrole.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}