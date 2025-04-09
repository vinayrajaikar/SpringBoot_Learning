package com.projects.todo_app.Todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/todo")
public class todo_controller {

    private final todo_service todoService;

    @Autowired
    public todo_controller(todo_service todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/get_todos")
    public Map<String,Object>get_todos(){
        List<todo>todos = todoService.getTodos();
        Map<String,Object>response = new HashMap<>();
        response.put("todos",todos);
        return response;
    }

    @PostMapping("/add_todo")
    public Map<String,Object> add_todo(@RequestBody todo Todo){
        todo addedTodo = todoService.addTodo(Todo);
        Map<String,Object> response = new HashMap<>();
        response.put("message","Todo added successfully");
        response.put("todo",addedTodo);
        return response;
    }

    @PutMapping("/update_status/{id}")
    public Map<String,Object> update_todo(@PathVariable("id") Integer id){
        todo data=todoService.updateTodo(id);
        Map<String,Object>response=new HashMap<>();
        response.put("todo",data);
        response.put("message","status updated successfully");
        return response;
    }

    @DeleteMapping("/delete_todo/{id}")
    public Map<String,String> delete_todo(@PathVariable("id") Integer id){
        todoService.deleteTodo(id);
        Map<String,String>response=new HashMap<>();
        response.put("message","Todo successfully deleted");
        return response;
    }
}
