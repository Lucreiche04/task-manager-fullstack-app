package com.lucreiche.taskmanager.controller;

import com.lucreiche.taskmanager.model.Task;
import com.lucreiche.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/tasks")

public class TaskController {

    // Injection du service
    private final TaskService taskService;

    // Constructeur
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Récupérer toutes les tâches
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    // Récupérer une tâche par son ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // Créer une nouvelle tâche
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // Modifier une tâche
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestBody Task updatedTask) {

        return taskService.updateTask(id, updatedTask);
    }

    // Supprimer une tâche
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}