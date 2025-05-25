package spring.employee.employeepayrole.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import spring.employee.employeepayrole.dto.User;
import spring.employee.employeepayrole.entity.Employee;
import spring.employee.employeepayrole.service.EmployeeService;
import spring.employee.employeepayrole.util.EmployeeUtil;

import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody User employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = EmployeeUtil.getErrors(bindingResult);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Employee saved = employeeService.create(employeeDTO);
        return ResponseEntity.ok("Employee created with ID: " + saved.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @Valid @RequestBody User employeeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = EmployeeUtil.getErrors(bindingResult);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Employee updated = employeeService.update(id, employeeDTO);
        return ResponseEntity.ok("Employee updated with name: " + updated.getName());
    }
}