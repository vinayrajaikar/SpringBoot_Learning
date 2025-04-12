package com.projects.todo_app.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface user_repository extends JpaRepository<user,Integer> {
    user findByUsername(String username);
}
