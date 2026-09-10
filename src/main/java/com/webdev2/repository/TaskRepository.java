package com.webdev2.repository;

import com.webdev2.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private Long currentId = 1L;

    public TaskRepository() {
        save(new Task(null, "Setup Spring Boot", "Configure Thymeleaf and Web starters", 1, true));
        save(new Task(null, "Implement Layered Architecture", "Separate Controller, Service, and Repository", 2, false));
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(currentId++);
            tasks.add(task);
        } else {
            deleteById(task.getId());
            tasks.add(task);
        }
        return task;
    }

    public boolean deleteById(Long id) {
        return tasks.removeIf(t -> t.getId().equals(id));
    }
}