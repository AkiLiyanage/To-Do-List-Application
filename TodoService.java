package com.example.todo.service;

import com.example.todo.model.Task;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    private List<Task> tasks = new ArrayList<>();

    // Add a task
    public Task addTask(String description) {
        Task task = new Task(UUID.randomUUID().toString(), description, false);
        tasks.add(task);
        return task;
    }

    // Mark a task as completed
    public Task markTaskAsCompleted(String id) {
        Task task = tasks.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
        if (task != null) {
            task.setCompleted(true);
        }
        return task;
    }

    // Delete a task
    public void deleteTask(String id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

    // View all tasks
    public List<Task> getAllTasks() {
        return tasks;
    }
}
