package ru.cybd.service;

import ru.cybd.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    Optional<Customer> putCustomerById(Long id, Customer updatedCustomer);

    void deleteCustomerById(Long id);
}
