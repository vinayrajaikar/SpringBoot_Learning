package com.projects.todo_app.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class user_service implements UserDetailsService {

    private final user_repository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public user_service(user_repository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = repository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("user not found");
        }
        return new User(user.getUsername(),user.getPassword(), Collections.emptyList());
    }

    public user register_user(user user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public boolean existing_user(String username){
        user user = repository.findByUsername(username);
        System.out.println("User: "+user);
        if(user == null){
            return false;
        }
        else{
            return true;
        }
    }

}
