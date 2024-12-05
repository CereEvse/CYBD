package ru.cybd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cybd.model.Employee;
import ru.cybd.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    ResponseEntity<Void> addEmployee(@RequestBody @Valid Employee employee,
                                 BindingResult bindingResult){
        employeeService.addEmployee(employee);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());

    }

    @GetMapping("/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        return employeeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody @Validated Employee updatedEmployee) {
        Optional<Employee> updatedEmployeeOptional = employeeService.putEmployeeById(id, updatedEmployee);
        return updatedEmployeeOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }
}