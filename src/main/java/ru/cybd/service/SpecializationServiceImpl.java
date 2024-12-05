package ru.cybd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cybd.exceptions.ExceptionHandler;
import ru.cybd.model.Specialization;
import ru.cybd.repository.SpecializationRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SpecializationServiceImpl implements SpecializationService{
    private final SpecializationRepository specializationRepository;
    private final ExceptionHandler exceptionHandler;

    @Override
    public void addSpecialization(Specialization specialization) {
        specializationRepository.save(specialization);
    }

    @Override
    public List<Specialization> getAllSpecializations() {
        return specializationRepository.findAll();
    }

    @Override
    public Optional<Specialization> getSpecializationById(Long id) {
        return specializationRepository.findById(id);
    }

    @Override
    public Optional<Specialization> putSpecializationById(Long id, Specialization updatedSpecialization) {
        Optional<Specialization> existingSpecialization = specializationRepository.findById(id);
        if (existingSpecialization.isPresent()) {
            Specialization specializationToUpdate = existingSpecialization.get();
            if (updatedSpecialization.getTitle() != null) {
                specializationToUpdate.setTitle(updatedSpecialization.getTitle());
            }
            specializationRepository.save(specializationToUpdate);
        }
        return existingSpecialization;
    }

    @Override
    public void deleteSpecializationById(Long id) {
        specializationRepository.deleteById(id);
    }
}
