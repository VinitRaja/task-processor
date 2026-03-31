package com.example.taskprocessor;

import jakarta.validation.Valid;
import com.example.taskprocessor.dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tasks", consumes = "application/json", produces = "application/json")
public class TaskController {
    
    private final TaskService service;

    public TaskController(TaskService service) { 
        this.service = service; 
    }

    @PostMapping
    public ResponseEntity<String> submit(@Valid @RequestBody TaskDto dto) {
        service.processAndQueue(dto.getPayload());
        return ResponseEntity.ok("Queued & Saved");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTask(@PathVariable Long id) {
        // service.getTask returns the entity or throws an exception
        return ResponseEntity.ok(service.getTask(id));
    }
}
