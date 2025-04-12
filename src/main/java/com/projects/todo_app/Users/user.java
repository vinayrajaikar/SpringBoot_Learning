package com.projects.todo_app.Users;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.projects.todo_app.Todos.todo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Users")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username",nullable = false)
    private String username;

    @Column(name="password",nullable = false)
    private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<todo>todos=new ArrayList<>();

    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public user() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<todo> getTodos() {
        return todos;
    }

    public void setTodos(List<todo> todos) {
        this.todos = todos;
    }
}
