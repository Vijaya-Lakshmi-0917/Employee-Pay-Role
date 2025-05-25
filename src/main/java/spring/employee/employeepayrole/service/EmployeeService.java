package spring.employee.employeepayrole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.employee.employeepayrole.dto.User;
import spring.employee.employeepayrole.entity.Employee;
import spring.employee.employeepayrole.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee create(User dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        return employeeRepository.save(emp);
    }

    public Employee update(Long id, User dto) {
        Optional<Employee> existing = employeeRepository.findById(id);
        if (existing.isPresent()) {
            Employee emp = existing.get();
            emp.setName(dto.getName());
            return employeeRepository.save(emp);
        } else {
            throw new RuntimeException("Employee not found with id " + id);
        }
    }
}