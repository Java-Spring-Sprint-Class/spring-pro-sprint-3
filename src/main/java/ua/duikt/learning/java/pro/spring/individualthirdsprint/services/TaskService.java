package ua.duikt.learning.java.pro.spring.individualthirdsprint.services;

import org.springframework.stereotype.Service;
import ua.duikt.learning.java.pro.spring.individualthirdsprint.entities.Task;
import ua.duikt.learning.java.pro.spring.individualthirdsprint.repositories.TaskRepository;

import java.util.List;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        // TODO: Call the repository's findAll() method
        return List.of();
    }

    public Task createTask(Task task) {
        // TODO: Save the task to the database using save()
        return null;
    }

    // ... other methods
}
