package ua.duikt.learning.java.pro.spring.individualthirdsprint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
// TODO: This interface should extend JpaRepository<Task, Long>
@Repository
public interface TaskRepository extends JpaRepository<?, ?> {

    // TODO: Try declaring a method to find tasks by status:
    // List<Task> findByCompleted(boolean completed);
}

