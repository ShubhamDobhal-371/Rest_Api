package com.shiubhu.RestApi_01.service.impl;

import com.shiubhu.RestApi_01.dao.UserRepository;
import com.shiubhu.RestApi_01.model.User;
import com.shiubhu.RestApi_01.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;//field Injection


//   save user data in database
    @Override
    public User createUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

//    update user information
    @Override
    public User updateUser(User user, Long uid) {
        User user1 = userRepository.findById(uid).get();
        user1.setUage(user.getUage());
        user1.setUabout(user.getUabout());
        user1.setUemail(user.getUemail());

        User updateduser = userRepository.save(user1);

        return updateduser;
    }

    @Override
    public User getSingleUser(Long uid) {
        return null;
    }

    @Override
    public List<User> getAllUSer() {
        return null;
    }

    @Override
    public void deleteUser(Long uid) {

    }

    @Override
    public void deleteAllUser() {

    }
}
