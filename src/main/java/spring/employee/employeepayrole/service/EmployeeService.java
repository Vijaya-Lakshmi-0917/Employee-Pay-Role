package spring.employee.employeepayrole.service;

import org.springframework.stereotype.Service;
import spring.employee.employeepayrole.dto.User;
import spring.employee.employeepayrole.entity.Employee;
import spring.employee.employeepayrole.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee createEmployee(User user) {
        Employee employee = new Employee(user.getName(), user.getSalary(), user.getEmail(), user.getDepartment());
        return repo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public Employee updateEmployee(Long id, User user) {
        Employee emp = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setName(user.getName());
        emp.setSalary(user.getSalary());
        emp.setEmail(user.getEmail());
        emp.setDepartment(user.getDepartment());
        return repo.save(emp);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}