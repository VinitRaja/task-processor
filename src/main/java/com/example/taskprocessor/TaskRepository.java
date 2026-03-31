package com.example.taskprocessor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    // Basic CRUD operations like save(), findById(), and delete() are already included!
}