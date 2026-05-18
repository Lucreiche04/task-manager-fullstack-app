package com.lucreiche.taskmanager.service;

import com.lucreiche.taskmanager.model.Task;
import com.lucreiche.taskmanager.repository.TaskRepository;
//indique que cette classe est un service
import org.springframework.stereotype.Service;

//Import de la classe List pour gérer des listes de tâches
import java.util.List;

@Service

public class TaskService {
    // Déclaration du repository (accès aux données)
    // final = ne peut être assigné qu'une seule fois (bonne pratique)
    private final TaskRepository taskRepository;

    /**
     * Constructeur (injection de dépendance)
     * Spring injecte automatiquement TaskRepository ici
     */
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Récupère toutes les tâches en base de données
     * @return liste de toutes les tâches
     */
    /*public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }*/

    /**
     * Crée et sauvegarde une nouvelle tâche en base
     * @param task objet Task à sauvegarder
     * @return la tâche sauvegardée (avec ID généré par la DB)
     */
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    /*public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }*/

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, Task task){
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

}
