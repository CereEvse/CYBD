package ru.cybd.service;

import ru.cybd.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    void addTask(Task task);

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Long id);

    Optional<Task> putTaskById(Long id, Task updatedTask);

    void deleteTaskById(Long id);
}
