package com.shiubhu.RestApi_01.controller;

import com.shiubhu.RestApi_01.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServiceI userServiceI;
}
