package ru.cybd.service;

import ru.cybd.model.PersonalData;

import java.util.List;
import java.util.Optional;

public interface PersonalDataService {
    void addPersonalData(PersonalData personalData);

    List<PersonalData> getAllPersonalDatas();

    Optional<PersonalData> getPersonalDataById(Long id);

    Optional<PersonalData> putPersonalDataById(Long id, PersonalData updatedPersonalData);

    void deletePersonalDataById(Long id);
}
