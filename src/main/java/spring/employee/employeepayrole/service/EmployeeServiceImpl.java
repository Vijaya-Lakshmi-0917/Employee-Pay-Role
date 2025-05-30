package spring.employee.employeepayrole.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.employee.employeepayrole.dto.User;
import spring.employee.employeepayrole.entity.Employee;
import spring.employee.employeepayrole.exception.UserNotFoundException;
import spring.employee.employeepayrole.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee createEmployee(User user) {
        Employee employee = Employee.builder()
                .name(user.getName())
                .gender(user.getGender())
                .startDate(user.getStartDate())
                .note(user.getNote())
                .profilePic(user.getProfilePic())

                .salary(user.getSalary())
                .build();
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Employee with id " + id + " not found"));
    }

    @Override
    public Employee updateEmployee(Long id, User user) {
        Employee existing = getEmployeeById(id);
        existing.setName(user.getName());
        existing.setGender(user.getGender());
        existing.setStartDate(user.getStartDate());
        existing.setNote(user.getNote());
        existing.setProfilePic(user.getProfilePic());
        existing.setDepartment(user.getDepartment());
        existing.setSalary(user.getSalary());
        return repository.save(existing);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee existing = getEmployeeById(id);
        repository.delete(existing);
    }

    @Override
    public List<Employee> getEmployeesFromSales() {
        return repository.findEmployeesInSalesDepartment();
    }
}