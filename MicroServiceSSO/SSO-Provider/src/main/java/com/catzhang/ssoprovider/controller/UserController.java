package com.catzhang.ssoprovider.controller;

import com.catzhang.ssoprovider.pojo.User;
import com.catzhang.ssoprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/checkName/{un}", method = RequestMethod.GET)
    public String checkName(@PathVariable(value = "un") String username) {
        try {
            final Integer integer = this.userService.checkUser(username);
            String info = null;
            if (integer == 1) {
                info = "User is existed...";
            } else {
                info = "User does not exist to register!!!";
            }
            return info;
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(User user) {
        String info = null;
        try {
            final Boolean result = this.userService.addUser(user);
            if (result == true) {
                info = "User registration successful!!!";
            } else {
                info = "User is existed...";
            }
        } catch (Exception e) {
            e.printStackTrace();
            info = "System exception";
        }
        return info;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("un") String username,
                            @RequestParam("pwd") String password) {
        String result = this.userService.loginUser(username, password);
        if ("success".equals(result)) {
            return "login——success";
        } else {
            return "login——error";
        }
    }
}
