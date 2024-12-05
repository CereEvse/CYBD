package ru.cybd.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cybd.model.Task;
import ru.cybd.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")

public class TaskController {
    private final TaskService taskService;

    @PostMapping
    ResponseEntity<Void> addTask(@RequestBody @Valid Task task,
                                  BindingResult bindingResult){
        taskService.addTask(task);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());

    }

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> taskOptional = taskService.getTaskById(id);
        return taskOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<Task> updateTaskById(@PathVariable Long id, @RequestBody @Validated Task updatedTask) {
        Optional<Task> updatedTaskOptional = taskService.putTaskById(id, updatedTask);
        return updatedTaskOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return ResponseEntity.ok().build();
    }

}
