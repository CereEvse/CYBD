package ru.cybd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cybd.model.Contact;
import ru.cybd.service.ContactService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Contact")

public class ContactController {

    private final ContactService contactService;


    @PostMapping
    ResponseEntity<Void> addContact(@RequestBody @Valid Contact contact,
                                  BindingResult bindingResult){
        contactService.addContact(contact);
        return ResponseEntity.ok().build();

    }


    @GetMapping
    ResponseEntity<List<Contact>> getAllContact(){
        return ResponseEntity.ok(contactService.getAllContacts());
    }


    @GetMapping("/{id}")
    ResponseEntity<Contact> getContactById(@PathVariable Long id){
        Optional<Contact> contactOptional = contactService.getContactById(id);
        return contactOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<Contact> updateContactById(@PathVariable Long id, @RequestBody Contact updatedContact) {
        Optional<Contact> updatedContactOptional = contactService.putContactById(id, updatedContact);
        return updatedContactOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteContactById(@PathVariable Long id){
        contactService.deleteContactById(id);
        return ResponseEntity.ok().build();
    }

}
