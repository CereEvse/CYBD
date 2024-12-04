package ru.cybd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.cybd.model.Addres;

public interface AddresRepository extends JpaRepository<Addres, Long>, PagingAndSortingRepository<Addres, Long> {
}
