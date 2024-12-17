package ru.cybd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cybd.model.Project;
import ru.cybd.service.ProjectService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    ResponseEntity<Void> addProject(@RequestBody @Valid Project project,
                                     BindingResult bindingResult){
        projectService.addProject(project);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    ResponseEntity<List<Project>> getAllProjects(){
        return ResponseEntity.ok(projectService.getAllProjects());

    }

    @GetMapping("/{id}")
    ResponseEntity<Project> getProjectById(@PathVariable Long id){
        Optional<Project> projectOptional = projectService.getProjectById(id);
        return projectOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<Project> updateProjectById(@PathVariable Long id, @RequestBody @Validated Project updatedProject) {
        Optional<Project> updatedProjectOptional = projectService.putProjectById(id, updatedProject);
        return updatedProjectOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProjectById(@PathVariable Long id){
        projectService.deleteProjectById(id);
        return ResponseEntity.ok().build();
    }
}
