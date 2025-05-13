package com.example.repository; // Balík pre repozitáre / Package for repositories

import com.example.model.Task; // Import entity Task / Import Task entity
import org.springframework.data.jpa.repository.JpaRepository;

// Repozitár pre entitu Task / Repository for Task entity
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Dedi metódy pre CRUD operácie / Inherits CRUD methods (save, findAll, deleteById, etc.)
}
