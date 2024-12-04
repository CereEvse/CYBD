package ru.cybd.service;

import org.springframework.data.domain.Page;
import ru.cybd.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    void addContact(Contact contact);

    List<Contact> getAllContacts();

    Optional<Contact> getContactById(Long id);

    Optional<Contact> putContactById(Long id, Contact updatedContact);

    void deleteContactById(Long id);
}
