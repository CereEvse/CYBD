package ru.cybd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cybd.exceptions.ExceptionHandler;
import ru.cybd.model.PersonalData;
import ru.cybd.repository.PersonalDataRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class PersonalDataServiceImpl implements PersonalDataService {
    private final PersonalDataRepository personalDataRepository;
    private final ExceptionHandler exceptionHandler;

    @Override
    public void addPersonalData(PersonalData personalData) {
        personalDataRepository.save(personalData);
    }

    @Override
    public List<PersonalData> getAllPersonalDatas() {
        return personalDataRepository.findAll();
    }

    @Override
    public Optional<PersonalData> getPersonalDataById(Long id) {
        return personalDataRepository.findById(id);
    }

    @Override
    public Optional<PersonalData> putPersonalDataById(Long id, PersonalData updatedPersonalData) {
        Optional<PersonalData> existingPersonalData = personalDataRepository.findById(id);
        if (existingPersonalData.isPresent()) {
            PersonalData personalDataToUpdate = existingPersonalData.get();
            if (updatedPersonalData.getPassportSeries() != null) {
                personalDataToUpdate.setPassportSeries(updatedPersonalData.getPassportSeries());
            }
            if (updatedPersonalData.getPassportNumber() != null) {
                personalDataToUpdate.setPassportNumber(updatedPersonalData.getPassportNumber());
            }
            if (updatedPersonalData.getPhoto() != null) {
                personalDataToUpdate.setPhoto(updatedPersonalData.getPhoto());
            }
            personalDataRepository.save(personalDataToUpdate);
        }
        return existingPersonalData;
    }

    @Override
    public void deletePersonalDataById(Long id) {
        personalDataRepository.deleteById(id);
    }
}
