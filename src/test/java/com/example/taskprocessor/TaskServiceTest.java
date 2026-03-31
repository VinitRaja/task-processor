package com.example.taskprocessor;

import com.example.taskprocessor.exception.TaskNotFoundException;
import com.example.taskprocessor.TaskEntity;
import com.example.taskprocessor.TaskRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock 
    private TaskRepository repo;

    // Mocking the WebClient.Builder since TaskService requires it in the constructor
    @Mock 
    private WebClient.Builder webClientBuilder;

    @InjectMocks 
    private TaskService service;

    @Test
    public void testGetTask() {
        // Arrange
        TaskEntity mockEntity = new TaskEntity();
        mockEntity.setPayload("test data");
        
        Mockito.when(repo.findById(1L)).thenReturn(Optional.of(mockEntity));

        // Act
        TaskEntity result = service.getTask(1L);
        
        // Assert
        assertEquals("test data", result.getPayload());
    }
}
