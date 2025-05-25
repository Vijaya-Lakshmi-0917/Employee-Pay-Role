package spring.employee.employeepayrole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.employee.employeepayrole.entity.Employee;
import spring.employee.employeepayrole.repository.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        Employee saved = repository.save(employee);
        return ResponseEntity.ok("Created Employee with ID: " + saved.getId());
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee newEmp) {
        return repository.findById(id).map(emp -> {
            emp.setName(newEmp.getName());
            emp.setDepartment(newEmp.getDepartment());
            emp.setSalary(newEmp.getSalary());
            repository.save(emp);
            return ResponseEntity.ok("Employee updated.");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return repository.findById(id).map(emp -> {
            repository.delete(emp);
            return ResponseEntity.ok("Employee deleted.");
        }).orElse(ResponseEntity.notFound().build());
    }
}