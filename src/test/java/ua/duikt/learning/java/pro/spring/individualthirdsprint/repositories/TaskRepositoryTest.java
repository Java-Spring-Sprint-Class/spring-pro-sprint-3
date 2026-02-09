package ua.duikt.learning.java.pro.spring.individualthirdsprint.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ua.duikt.learning.java.pro.spring.individualthirdsprint.entities.Task;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @DisplayName("Test 1: Save and retrieve a task")
    void shouldSaveAndFindTask() {
        Task newTask = new Task("Learn JPA", false);
        Task savedTask = taskRepository.save(newTask);

        assertNotNull(savedTask.getId(), "ID should be generated automatically (@GeneratedValue)");

        Optional<Task> foundTask = taskRepository.findById(savedTask.getId());
        assertTrue(foundTask.isPresent(), "The task should be found by ID");
        assertEquals("Learn JPA", foundTask.get().getTitle());
    }

    @Test
    @DisplayName("Test 2: Delete a task")
    void shouldDeleteTask() {
        Task task = new Task("To be deleted", true);
        Task saved = taskRepository.save(task);

        taskRepository.deleteById(saved.getId());

        Optional<Task> search = taskRepository.findById(saved.getId());
        assertTrue(search.isEmpty(), "The task should be deleted from the DB");
    }

    @Test
    @DisplayName("Test 3: Magic Methods (findByCompleted)")
    void shouldFindCompletedTasks() {
        taskRepository.save(new Task("Task 1", true));
        taskRepository.save(new Task("Task 2", false));
        taskRepository.save(new Task("Task 3", true));

        var completedTasks = taskRepository.findByCompleted(true);
        assertThat(completedTasks).hasSize(2);
    }
}
