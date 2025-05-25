package spring.employee.employeepayrole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.employee.employeepayrole.dto.User;
import spring.employee.employeepayrole.entity.Employee;
import spring.employee.employeepayrole.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    private Employee toEntity(User dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        emp.setDepartment(null);
        return emp;
    }

    private User toDTO(Employee emp) {
        return new User(emp.getName(), emp.getSalary());
    }

    public User createEmployee(User dto) {
        Employee emp = toEntity(dto);
        Employee saved = repository.save(emp);
        return toDTO(saved);
    }

    public List<User> getAllEmployees() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<User> getEmployeeById(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    public boolean updateEmployee(Long id, User newDto) {
        Optional<Employee> optionalEmp = repository.findById(id);
        if (optionalEmp.isPresent()) {
            Employee emp = optionalEmp.get();
            emp.setName(newDto.getName());
            emp.setSalary(newDto.getSalary());
            repository.save(emp);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(Long id) {
        Optional<Employee> optionalEmp = repository.findById(id);
        if (optionalEmp.isPresent()) {
            repository.delete(optionalEmp.get());
            return true;
        }
        return false;
    }
}