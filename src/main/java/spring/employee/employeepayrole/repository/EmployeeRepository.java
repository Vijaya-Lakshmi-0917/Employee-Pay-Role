package spring.employee.employeepayrole.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.employee.employeepayrole.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.department = 'Sales'")
    List<Employee> findEmployeesInSalesDepartment();
}