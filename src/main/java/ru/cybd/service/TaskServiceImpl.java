package ru.cybd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cybd.exceptions.ExceptionHandler;
import ru.cybd.model.Employee;
import ru.cybd.model.Project;
import ru.cybd.model.Task;
import ru.cybd.repository.EmployeeRepository;
import ru.cybd.repository.ProjectRepository;
import ru.cybd.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService{

    private final ExceptionHandler exceptionHandler;
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void addTask(Task task) {
        Project project = task.getProject();
        Employee employee = task.getEmployee();

        if (project != null && project.getIdProject() != null) {
            project = projectRepository.findById(project.getIdProject()).orElse(null);
        }
        if (employee != null && employee.getIdEmployee() != null) {
            employee = employeeRepository.findById(employee.getIdEmployee()).orElse(null);
        }

        task.setProject(project);
        task.setEmployee(employee);

        taskRepository.save(task);

    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Optional<Task> putTaskById(Long id, Task updatedTask) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if(existingTask.isPresent()){

            Task taskToUpdate = existingTask.get();
            if(updatedTask.getProject() != null && updatedTask.getProject().getIdProject() != null) {
                Project project = projectRepository.findById(updatedTask.getProject().getIdProject()).orElse(null);
                taskToUpdate.setProject(project);
            }

            if(updatedTask.getTask() != null) {
                taskToUpdate.setTask(updatedTask.getTask());
            }

            if(updatedTask.getEmployee() != null && updatedTask.getEmployee().getIdEmployee() != null) {
                Employee employee = employeeRepository.findById(updatedTask.getEmployee().getIdEmployee()).orElse(null);
                taskToUpdate.setEmployee(employee);
            }
            taskRepository.save(taskToUpdate);
        }
        return existingTask;
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);

    }
}
