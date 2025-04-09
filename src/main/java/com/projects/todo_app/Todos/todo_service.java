package com.projects.todo_app.Todos;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class todo_service {
    private final todo_repository repository;

    @Autowired
    public todo_service(todo_repository repository) {
        this.repository = repository;
    }

    public List<todo>getTodos(){
        return repository.findAll();
    }

    public todo addTodo(todo todo) {
//        System.out.println(todo);
        return repository.save(todo);
    }

    @Transactional
    public todo updateTodo(Integer id) {
        todo todo = repository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        "Invalid id"
                ));
        todo.setStatus(!todo.getStatus());
        return todo;
    }

    public void deleteTodo(Integer id) {
        boolean exists = repository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Invalid id");
        }
        repository.deleteById(id);
    }
}
