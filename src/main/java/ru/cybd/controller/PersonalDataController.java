package ru.cybd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cybd.model.PersonalData;
import ru.cybd.service.PersonalDataService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/PersonalData")

public class PersonalDataController {
    private final PersonalDataService personalDataService;


    @PostMapping
    ResponseEntity<Void> addPersonalData(@RequestBody @Valid PersonalData personalData,
                                    BindingResult bindingResult){
        personalDataService.addPersonalData(personalData);
        return ResponseEntity.ok().build();

    }


    @GetMapping
    ResponseEntity<List<PersonalData>> getAllPersonalData(){
        return ResponseEntity.ok(personalDataService.getAllPersonalDatas());
    }


    @GetMapping("/{id}")
    ResponseEntity<PersonalData> getPersonalDataById(@PathVariable Long id){
        Optional<PersonalData> personalDataOptional = personalDataService.getPersonalDataById(id);
        return personalDataOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<PersonalData> updatePersonalDataById(@PathVariable Long id, @RequestBody PersonalData updatedPersonalData) {
        Optional<PersonalData> updatedPersonalDataOptional = personalDataService.putPersonalDataById(id, updatedPersonalData);
        return updatedPersonalDataOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePersonalDataById(@PathVariable Long id){
        personalDataService.deletePersonalDataById(id);
        return ResponseEntity.ok().build();
    }
}
