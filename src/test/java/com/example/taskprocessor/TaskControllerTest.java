package com.example.taskprocessor;

import com.example.taskprocessor.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean; 
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;

// Static imports for Fluent API (Required for post, status, and content)
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired 
    private MockMvc mockMvc;

    @MockitoBean 
    private TaskService service;

    @Test
    @WithMockUser
    public void testSubmit() throws Exception {
        mockMvc.perform(post("/api/tasks")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"payload\":\"hello world\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Queued & Saved"));
    }
}
