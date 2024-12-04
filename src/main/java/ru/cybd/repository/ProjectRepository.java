package ru.cybd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.cybd.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>, PagingAndSortingRepository<Project, Long> {
}
