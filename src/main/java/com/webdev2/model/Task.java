package com.webdev2.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Task {

    private Long id;

    @NotBlank(message = "Task title is required.")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters.")
    private String title;

    @NotBlank(message = "Task description is required.")
    private String description;

    @NotNull(message = "Priority level is required.")
    @Min(value = 1, message = "Priority must be at least 1.")
    @Max(value = 5, message = "Priority cannot exceed 5.")
    private Integer priority;

    private boolean completed;

    public Task() {}

    public Task(Long id, String title, String description, Integer priority, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = completed;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}