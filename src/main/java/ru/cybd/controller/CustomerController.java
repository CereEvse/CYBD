package ru.cybd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cybd.model.Customer;
import ru.cybd.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    ResponseEntity<Void> addCustomer(@RequestBody @Valid Customer customer,
                                     BindingResult bindingResult){
        customerService.addCustomer(customer);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());

    }

    @GetMapping("/{id}")
    ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        return customerOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<Customer> updateCustomerById(@PathVariable Long id, @RequestBody @Validated Customer updatedCustomer) {
        Optional<Customer> updatedCustomerOptional = customerService.putCustomerById(id, updatedCustomer);
        return updatedCustomerOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }
}
