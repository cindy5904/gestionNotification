package org.example.gestionnotification.controller;

import org.example.gestionnotification.entity.Task;
import org.example.gestionnotification.service.Taskservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private Taskservice taskservice;

    @GetMapping
    public List<Task> findAllTask() {
        return taskservice.findAll();
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestParam String name, @RequestParam boolean status) {
        return ResponseEntity.ok(taskservice.createTask(name, String.valueOf(status)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable int id) {
        return ResponseEntity.ok(taskservice.findById(id));
    }
}
