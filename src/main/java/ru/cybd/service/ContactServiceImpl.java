package ru.cybd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.cybd.exceptions.ExceptionHandler;
import ru.cybd.model.Contact;
import ru.cybd.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContactServiceImpl {
    private final ContactRepository contactRepository;
    private final ExceptionHandler exceptionHandler;

    @Override
    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public Optional<Contact> putContactById(Long id, Contact updatedContact) {
        Optional<Contact> existingContact = contactRepository.findById(id);
        if (existingContact.isPresent()) {
            Contact contactToUpdate = existingContact.get();
            if (updatedContact.getTelephone() != null) {
                contactToUpdate.setTelephone(updatedContact.getTelephone());
            }
            if (updatedContact.getEmail() != null) {
                contactToUpdate.setEmail(updatedContact.getEmail());
            }
            contactRepository.save(contactToUpdate);
        }
        return existingContact;
    }

    @Override
    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }
}
