package spring.employee.employeepayrole.service;

import spring.employee.employeepayrole.dto.User;
import spring.employee.employeepayrole.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(User user);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, User user);
    void deleteEmployee(Long id);
}