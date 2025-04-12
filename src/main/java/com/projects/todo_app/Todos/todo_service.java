package com.projects.todo_app.Todos;

import com.projects.todo_app.Users.user_repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projects.todo_app.Users.user;

import java.util.List;
import java.util.Optional;

@Service
public class todo_service {
    private final todo_repository todoRepo;
    private final user_repository userRepo;

    @Autowired
    public todo_service(todo_repository todoRepo, user_repository userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public List<todo>getTodos(int userId){
        Optional<user> user_data = userRepo.findById(userId);
        if(user_data.isEmpty()){
            throw new IllegalStateException("Invalid user Id");
        }
        return user_data.get().getTodos();
    }

    public todo addTodo(todo todo,int userId) {
      System.out.println(todo);
        Optional<user> user_data = userRepo.findById(userId);
        if(user_data.isEmpty()){
            throw new IllegalStateException("Invalid user Id");
        }
        user existing_user = user_data.get();
        todo todo_obj = new todo(todo.getTodoItem(), todo.getStatus());
        todo_obj.setUser(existing_user);
        return todoRepo.save(todo_obj);
//        return user_data.get().getTodos().add(todo);
    }

    @Transactional
    public todo updateTodo(Integer id) {
        Optional<todo>todo = todoRepo.findById(id);
        if(todo.isEmpty()){
            throw new IllegalStateException("Invalid id");
        }
        todo existing_todo = todo.get();
        existing_todo.setStatus(!existing_todo.getStatus());
        return existing_todo;
    }

    public void deleteTodo(Integer id) {
        boolean exists = todoRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("Invalid id");
        }
        todoRepo.deleteById(id);
    }
}
