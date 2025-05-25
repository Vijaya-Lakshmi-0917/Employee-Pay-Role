package spring.employee.employeepayrole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.employee.employeepayrole.entity.Employee;
import spring.employee.employeepayrole.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee newEmp) {
        return repository.findById(id).map(emp -> {
            emp.setName(newEmp.getName());
            emp.setDepartment(newEmp.getDepartment());
            emp.setSalary(newEmp.getSalary());
            return repository.save(emp);
        }).orElse(null);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return repository.findById(id).map(emp -> {
            repository.delete(emp);
            return true;
        }).orElse(false);
    }
}
