package com.shiubhu.RestApi_01.service.impl;

import com.shiubhu.RestApi_01.dao.UserRepository;
import com.shiubhu.RestApi_01.model.User;
import com.shiubhu.RestApi_01.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public User getSingleUser(Long uid) throws Exception {

        Optional<User> user = userRepository.findById(uid);
//        handle null pointer exception using java8 feature Optional class method "isPresent()".
//        throgh the optional class(handle only nullpointer exceptin) we avoide nullpointer exception.

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("Resource not found" + uid);
        }
//handle nullpointer exeption using lambda function java 8 feature.
//
//        User user1=userRepository.findById(uid).get()
//                .orElseThrow(()->new RuntimeException("Resource not found"+uid));
    }

    @Override
    public List<User> getAllUSer() {

        List<User> alluser = userRepository.findAll();
        return alluser;
    }

    @Override
    public void deleteUser(Long uid) {

        User user = userRepository.findById(uid).
                orElseThrow(() -> new RuntimeException("Resource not found on server"));

        userRepository.delete(user);



    }

    @Override
    public void deleteAllUser() {


    }
}
