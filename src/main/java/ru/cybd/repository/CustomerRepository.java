package ru.cybd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.cybd.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long> {
}
