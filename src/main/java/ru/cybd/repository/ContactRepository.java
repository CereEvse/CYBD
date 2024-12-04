package ru.cybd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.cybd.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>, PagingAndSortingRepository<Contact, Long> {
}
