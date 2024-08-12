package org.example.gestionnotification.service;

import org.example.gestionnotification.annotation.AnnotationLog;
import org.example.gestionnotification.annotation.AnnotationPerformance;
import org.example.gestionnotification.entity.Task;
import org.example.gestionnotification.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Taskservice {
    private final TaskRepository taskRepository;

    public Taskservice(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    private List<Task> tasks = new ArrayList<>();

    @AnnotationPerformance
    @AnnotationLog
    public Task createTask(String name, String status) {
        Task task = new Task();
        task.setName(name);
        task.setStatus(Boolean.parseBoolean(status));

        return taskRepository.save(task);
    }

    @AnnotationPerformance
    @AnnotationLog
    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    @AnnotationPerformance
    @AnnotationLog
    public Task findById(int id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()) {
            return taskOptional.get();
        }
        throw new RuntimeException("Task non trouvé");
    }




}
