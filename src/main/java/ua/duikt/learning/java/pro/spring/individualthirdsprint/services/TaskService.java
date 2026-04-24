package ua.duikt.learning.java.pro.spring.individualthirdsprint.services;

import org.springframework.stereotype.Service;
import ua.duikt.learning.java.pro.spring.individualthirdsprint.entities.Task;
import ua.duikt.learning.java.pro.spring.individualthirdsprint.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

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
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        // TODO: Save the task to the database using save()
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);   // returns Optional — task might not exist
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getByStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);  // your magic metho
    }
}