package com.shiubhu.RestApi_01.controller;

import com.shiubhu.RestApi_01.model.User;
import com.shiubhu.RestApi_01.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/user/{uid}")
    public ResponseEntity<User> updateUSer(@RequestBody User user,@PathVariable Long uid){
        User updateduser = userServiceI.updateUser(user, uid);
        return new ResponseEntity<User>(updateduser,HttpStatus.CREATED);
    }

//    Exception propagation concept when we handle exception in child then it propagete to parante class/main class

    @GetMapping("user/{uid}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long uid) throws Exception {
        User singleUser = userServiceI.getSingleUser(uid);
        return new ResponseEntity<User>(singleUser,HttpStatus.OK);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUSer = userServiceI.getAllUSer();
        return new ResponseEntity<List<User>>(allUSer,HttpStatus.OK);
    }


    @DeleteMapping("user/{uid}")
    public ResponseEntity<String> deleteUser(@PathVariable Long uid){
        userServiceI.deleteUser(uid);
        return new ResponseEntity<String>("Resource Remove succesfully",HttpStatus.OK);
    }

    @DeleteMapping("user/delete")
    public ResponseEntity<String> deleteAllUser(@PathVariable Long uid){
        userServiceI.deleteAllUser();
        return new ResponseEntity<String>("All Resource Remove succesfully",HttpStatus.OK);
    }


}
