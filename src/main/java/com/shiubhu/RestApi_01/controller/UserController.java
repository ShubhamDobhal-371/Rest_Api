package com.shiubhu.RestApi_01.controller;

import com.shiubhu.RestApi_01.model.User;
import com.shiubhu.RestApi_01.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //indicate which type of http methode call
public class UserController {
    @Autowired
    private UserServiceI userServiceI;



//    @RequestMapping(method = RequestMethod.POST, name = "/createuser")---->(Use before postmapping not exisest)
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User createduser = userServiceI.createUser(user);

        return new ResponseEntity<User>(createduser, HttpStatus.CREATED);//201

    }


}
