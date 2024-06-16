package com.shiubhu.RestApi_01.controller;

import com.shiubhu.RestApi_01.model.User;
import com.shiubhu.RestApi_01.service.UserServiceI;
//import lombok.extern.slf4j.Slf4j;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api") //indicate which type of http methode call
public class UserController {

//    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServiceI userServiceI;



//    @RequestMapping(method = RequestMethod.POST, name = "/createuser")---->(Use before postmapping not exisest)
    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user){
//        logger.info("Entering the req for save user data");
        log.info("Entering the req for save user data");

        User createduser = userServiceI.createUser(user);

        log.info("Completed the request for save user data");

        return new ResponseEntity<User>(createduser, HttpStatus.CREATED);//201

    }

    @PutMapping("/user/{uid}")
    public ResponseEntity<User> updateUSer(@RequestBody User user,@PathVariable Long uid){

        log.info("Entering the req for Update user data "+uid);
        User updateduser = userServiceI.updateUser(user, uid);
        log.info("Complete the req for Update user data "+uid);
        return new ResponseEntity<User>(updateduser,HttpStatus.CREATED);
    }

//    Exception propagation concept when we handle exception in child then it propagete to parante class/main class

    @GetMapping("user/{uid}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long uid) throws Exception {

        log.info("Entering the req for getSinle user data "+uid);
        User singleUser = userServiceI.getSingleUser(uid);
        log.info("Complete the req for getSinle user data "+uid);
        return new ResponseEntity<User>(singleUser,HttpStatus.OK);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUser(){
        log.info("Entering the req for get all user data");
        List<User> allUSer = userServiceI.getAllUSer();
        log.info("complete the request for get all user data");
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
