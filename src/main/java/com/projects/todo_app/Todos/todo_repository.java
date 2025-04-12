package com.projects.todo_app.Todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface todo_repository extends JpaRepository<todo,Integer> {
}
