package ru.cybd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cybd.exceptions.ExceptionHandler;
import ru.cybd.model.Project;
import ru.cybd.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService{
    private final ExceptionHandler exceptionHandler;
    private final ProjectRepository projectRepository;

    @Override
    public void addProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Optional<Project> putProjectById(Long id, Project updatedProject) {
        Optional<Project> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()) {
            Project projectToUpdate = existingProject.get();
            if (updatedProject.getTitle() != null) {
                projectToUpdate.setTitle(updatedProject.getTitle());
            }
            if (updatedProject.getDeadlines() != null) {
                projectToUpdate.setDeadlines(updatedProject.getDeadlines());
            }
            if (updatedProject.getBudget() != null) {
                projectToUpdate.setBudget(updatedProject.getBudget());
            }
            projectRepository.save(projectToUpdate);
        }
        return existingProject;
    }

    @Override
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);

    }
}
