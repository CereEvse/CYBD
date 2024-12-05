package ru.cybd.service;

import ru.cybd.model.Specialization;

import java.util.List;
import java.util.Optional;

public interface SpecializationService {
    void addSpecialization(Specialization specialization);

    List<Specialization> getAllSpecializations();

    Optional<Specialization> getSpecializationById(Long id);

    Optional<Specialization> putSpecializationById(Long id, Specialization updatedSpecialization);

    void deleteSpecializationById(Long id);
}
