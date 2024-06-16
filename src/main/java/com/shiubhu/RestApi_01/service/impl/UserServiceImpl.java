package com.shiubhu.RestApi_01.service.impl;

import com.shiubhu.RestApi_01.dao.UserRepository;
import com.shiubhu.RestApi_01.model.User;
import com.shiubhu.RestApi_01.service.UserServiceI;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserRepository userRepository;//field Injection


    //   save user data in database
    @Override
    public User createUser(User user) {
        log.info("Initialing the dao call for the save user data");
        User save = userRepository.save(user);
        log.info("complete the dao call for save the data");
        return save;
    }

    //    update user information
    @Override
    public User updateUser(User user, Long uid) {
        log.info("Initialing the dao call for the update user data " +uid);
        User user1 = userRepository.findById(uid).get();
        user1.setUage(user.getUage());
        user1.setUabout(user.getUabout());
        user1.setUemail(user.getUemail());
        user1.setUname(user.getUname());

        User updateduser = userRepository.save(user1);
        log.info("complete the dao call for save the data  " +uid);

        return updateduser;
    }

    @Override
    public User getSingleUser(Long uid) throws Exception {
        log.info("Initialing the dao call for the getSingle user data " +uid);
        Optional<User> user = userRepository.findById(uid);
//        handle null pointer exception using java8 feature Optional class method "isPresent()".
//        throgh the optional class(handle only nullpointer exceptin) we avoide nullpointer exception.

        if (user.isPresent()) {
            log.info("Compeleted the dao call for the getSingle user data " +uid);
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
        log.info("Initialing the the dao call for the get all user data");
        List<User> alluser = userRepository.findAll();
        log.info("Completed the dao call for the get all user data");
        return alluser;
    }

    @Override
    public void deleteUser(Long uid) {
        log.info("Initialing the dao call for the delete user data " +uid);
        User user = userRepository.findById(uid).orElseThrow(() -> new RuntimeException("Resource not found on server"));
        log.info("Complete the dao call for the getSingle user data " +uid);

        userRepository.delete(user);

    }

    @Override
    public void deleteAllUser() {
        userRepository.deleteAll();


    }
}
