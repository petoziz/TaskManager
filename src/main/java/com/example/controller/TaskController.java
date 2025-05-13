package com.example.controller;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Webový kontrolér | Web controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository; // Prístup k DB | Access to DB

    @GetMapping("/") // Zoznam úloh | Task list
    public String viewTasks(Model model) {
        List<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/tasks/new") // Formulár - nová úloha | Form - new task
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "create-task";
    }

    @PostMapping("/tasks") // Uloženie úlohy | Save task
    public String saveTask(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }

    @GetMapping("/tasks/delete/{id}") // Zmazanie úlohy | Delete task
    public String deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/tasks/complete/{id}") // Označiť ako hotové | Mark as completed
    public String completeTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
        }
        return "redirect:/";
    }

    @GetMapping("/tasks/edit/{id}") // Formulár - úprava úlohy | Form - edit task
    public String showEditForm(@PathVariable Long id, Model model) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            return "redirect:/";
        }
        model.addAttribute("task", task);
        return "edit-task";
    }

    @PostMapping("/tasks/update") // Uloženie úpravy | Save edit
    public String updateTask(@ModelAttribute Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }
}
