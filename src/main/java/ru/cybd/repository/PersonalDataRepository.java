package ru.cybd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.cybd.model.PersonalData;

public interface PersonalDataRepository extends JpaRepository<PersonalData, Long>, PagingAndSortingRepository<PersonalData, Long> {
}
