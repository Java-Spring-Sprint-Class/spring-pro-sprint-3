package ua.duikt.learning.java.pro.spring.individualthirdsprint.entities;

import java.util.Objects;

/**
 * Created by Mykyta Sirobaba on 20.01.2026.
 * email mykyta.sirobaba@gmail.com
 */
// TODO: Add the @Entity and @Table(name = "tasks") annotations
public class Task {

    // TODO: Add @Id and @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;

    // TODO: Hibernate requires a no-argument constructor. Do not remove it!
    public Task() {}

    public Task(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return completed == task.completed && Objects.equals(id, task.id) && Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, completed);
    }

    @Override
    public String
    toString() {
        return "Task{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", completed=" + completed +
               '}';
    }
}
