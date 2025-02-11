package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoController {
    @Autowired
    private TodoService todoService;

    // Add a task
    @PostMapping
    public Task addTask(@RequestParam String description) {
        return todoService.addTask(description);
    }

    // Mark a task as completed
    @PutMapping("/{id}/complete")
    public Task markTaskAsCompleted(@PathVariable String id) {
        return todoService.markTaskAsCompleted(id);
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        todoService.deleteTask(id);
    }

    // View all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return todoService.getAllTasks();
    }
}
