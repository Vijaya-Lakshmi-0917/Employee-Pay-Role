package spring.employee.employeepayrole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.employee.employeepayrole.dto.User;
import spring.employee.employeepayrole.entity.Employee;
import spring.employee.employeepayrole.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public User createEmployee(User dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        emp.setDepartment(null);

        Employee saved = repository.save(emp);
        return new User(saved.getName(), saved.getSalary());
    }

    public List<User> getAllEmployees() {
        return repository.findAll().stream()
                .map(emp -> new User(emp.getName(), emp.getSalary()))
                .collect(Collectors.toList());
    }

    public User getEmployeeById(Long id) {
        return repository.findById(id)
                .map(emp -> new User(emp.getName(), emp.getSalary()))
                .orElse(null);
    }

    public boolean updateEmployee(Long id, User dto) {
        return repository.findById(id).map(emp -> {
            emp.setName(dto.getName());
            emp.setSalary(dto.getSalary());
            repository.save(emp);
            return true;
        }).orElse(false);
    }

    public boolean deleteEmployee(Long id) {
        return repository.findById(id).map(emp -> {
            repository.delete(emp);
            return true;
        }).orElse(false);
    }
}