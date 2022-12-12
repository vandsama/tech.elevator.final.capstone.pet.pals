package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return this.userDao.getUserById(id);
    }

}
