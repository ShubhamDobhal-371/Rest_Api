package com.shiubhu.RestApi_01.service;

import com.shiubhu.RestApi_01.model.User;

import java.util.List;

public interface UserServiceI {

//    CRUD OPERATION
//    Create
    User createUser(User user);

//    Update
    User updateUser(User user,Long uid);

//    get
    User getSingleUser(Long uid);

    List<User> getAllUSer();

//    Delete

    void deleteUser(Long uid);

    void deleteAllUser();
}
