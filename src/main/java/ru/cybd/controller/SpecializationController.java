package ru.cybd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.cybd.model.Specialization;
import ru.cybd.service.SpecializationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Specialization")
public class SpecializationController {
    private final SpecializationService specializationService;


    @PostMapping
    ResponseEntity<Void> addSpecialization(@RequestBody @Valid Specialization specialization,
                                    BindingResult bindingResult){
        specializationService.addSpecialization(specialization);
        return ResponseEntity.ok().build();

    }


    @GetMapping
    ResponseEntity<List<Specialization>> getAllSpecialization(){
        return ResponseEntity.ok(specializationService.getAllSpecializations());
    }


    @GetMapping("/{id}")
    ResponseEntity<Specialization> getSpecializationById(@PathVariable Long id){
        Optional<Specialization> specializationOptional = specializationService.getSpecializationById(id);
        return specializationOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    ResponseEntity<Specialization> updateSpecializationById(@PathVariable Long id, @RequestBody Specialization updatedSpecialization) {
        Optional<Specialization> updatedSpecializationOptional = specializationService.putSpecializationById(id, updatedSpecialization);
        return updatedSpecializationOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteSpecializationById(@PathVariable Long id){
        specializationService.deleteSpecializationById(id);
        return ResponseEntity.ok().build();
    }
}
