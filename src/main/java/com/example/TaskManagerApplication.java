package com.example; // Balík aplikácie / Application package

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Hlavná trieda Spring Boot aplikácie / Main Spring Boot application class
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
		// Spustenie aplikácie / Start the application
	}

}
