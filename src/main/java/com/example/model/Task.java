package com.example.model; // Balík s entitami / Package for entity classes

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity // Označuje triedu ako entitu JPA / Marks class as a JPA entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifikátor úlohy / Task ID

    private String title; // Názov úlohy / Task title

    private String description; // Popis úlohy / Task description

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate; // Termín dokončenia / Due date

    private boolean completed; // Či je úloha hotová / Task status

    // Getre a setre / Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
