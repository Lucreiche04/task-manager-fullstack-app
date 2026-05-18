package com.lucreiche.taskmanager.controller;

import com.lucreiche.taskmanager.model.Task;
import com.lucreiche.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // crée une API REST
@RequestMapping("/tasks") // URL de base pour les endpoints

public class TaskController {

    // Déclaration du service(accès à la logique metier)
    // final = ne peut être assigné qu'une seule fois (bonne pratique)
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    /*@GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }*/

    @GetMapping
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    @PostMapping
    public Task createTask(Task task) {
        return taskService.createTask(task);
    }

    // Modifier une tâche
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    // Supprimer une tâche
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
