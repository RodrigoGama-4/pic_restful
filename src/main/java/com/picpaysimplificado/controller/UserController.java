package com.picpaysimplificado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        User newUser = this.userServices.createUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = this.userServices.getAllUser();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
}
