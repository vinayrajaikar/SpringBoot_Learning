package com.projects.todo_app;

import com.projects.todo_app.Todos.todo;
import com.projects.todo_app.Todos.todo_service;
import com.projects.todo_app.Users.user;
import com.projects.todo_app.Users.user_service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.List;

@SpringBootApplication
public class TodoAppMain {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppMain.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(12);
	}

	@Bean
	CommandLineRunner run(user_service userService, todo_service todoService){
		return args -> {
			user user1= userService.register_user(new user("vinay","1234"));
			todo todo1 = new todo("Go for a walk",false);
		};
	}

}


