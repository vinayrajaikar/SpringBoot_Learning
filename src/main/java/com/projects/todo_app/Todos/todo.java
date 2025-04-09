package com.projects.todo_app.Todos;


import jakarta.persistence.*;

@Entity(name="todos")
public class todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "todoItem",nullable = false)
    private String todoItem;

    @Column(name = "status",nullable = false)
    private boolean status;

    public todo() {
    }

    public todo(String todoItem, boolean status) {
        this.todoItem = todoItem;
        this.status = status;
    }

    public Integer getId(){
        return this.id;
    }

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", todoItem='" + todoItem + '\'' +
                ", status=" + status +
                '}';
    }
}
