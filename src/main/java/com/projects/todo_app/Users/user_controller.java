package com.projects.todo_app.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")

public class user_controller {

    private final user_service userService;

    @Autowired
    public user_controller(user_service userService){
        this.userService = userService;
    }

//    @PostMapping("/login")
//    public Map<String,Object>login(@RequestBody user user){
//    }

    @PostMapping("/register")
    public Map<String,Object>register(@RequestBody user user){

        boolean isExistingUser = userService.existing_user(user.getUsername());
//        System.out.println("isExisting user: "+isExistingUser);
        Map<String,Object>response=new HashMap<>();

        if(isExistingUser){
            response.put("message","username has been taken");
            return response;
        }

        user userData = userService.register_user(user);

        response.put("user",userData);
        response.put("message","user registered successfully");

        return response;
    }

}
