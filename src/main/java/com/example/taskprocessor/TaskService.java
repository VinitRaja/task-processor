package com.example.taskprocessor;

import com.example.taskprocessor.exception.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TaskService {
    private final Queue<String> queue = new ConcurrentLinkedQueue<>();
    private final TaskRepository repo;
    private final WebClient.Builder webClientBuilder;

    // Fixed: WebClient should be a reusable bean for better performance
    public TaskService(TaskRepository repo, WebClient.Builder webClientBuilder) {
        this.repo = repo;
        this.webClientBuilder = webClientBuilder;
    }

    public void processAndQueue(String data) {
        // Fixed: Ensure TaskEntity has a constructor that takes 'data' (see Entity fix below)
        repo.save(new TaskEntity(data)); 
        queue.add(data);
    }

    @Cacheable(value = "taskCache", key = "#id")
    public TaskEntity getTask(Long id) {
        return repo.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Scheduled(fixedDelay = 5000)
    public void processQueue() {
        String data = queue.poll();
        if (data != null) {
            // Reusing the configured webClient
            webClientBuilder.build() 
                     .post()
                     .uri("https://example.com")
                     .bodyValue(data)
                     .retrieve()
                     .toBodilessEntity()
                     .subscribe();
        }
    }
}
