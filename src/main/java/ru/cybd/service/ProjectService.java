package ru.cybd.service;

import ru.cybd.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    void addProject(Project project);

    List<Project> getAllProjects();

    Optional<Project> getProjectById(Long id);

    Optional<Project> putProjectById(Long id, Project updatedProject);

    void deleteProjectById(Long id);
}

