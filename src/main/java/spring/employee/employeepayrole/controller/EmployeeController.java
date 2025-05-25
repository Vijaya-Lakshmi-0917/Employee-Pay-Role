package spring.employee.employeepayrole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.employee.employeepayrole.dto.User;
import spring.employee.employeepayrole.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody User employeeDTO) {
        User saved = service.createEmployee(employeeDTO);
        return ResponseEntity.ok("Created Employee: " + saved.getName());
    }

    @GetMapping
    public List<User> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getEmployee(@PathVariable Long id) {
        User dto = service.getEmployeeById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody User dto) {
        boolean updated = service.updateEmployee(id, dto);
        if (updated) {
            return ResponseEntity.ok("Employee updated.");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean deleted = service.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.ok("Employee deleted.");
        }
        return ResponseEntity.notFound().build();
    }
}