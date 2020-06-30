package com.catzhang.ssoconsumer.controller;

import com.catzhang.ssoconsumer.feignApi.ProviderFeignApi;
import com.catzhang.ssoconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/consumer-user")
public class UserController {

    private final ProviderFeignApi providerFeignApi;

    @Autowired
    public UserController(ProviderFeignApi providerFeignApi) {
        this.providerFeignApi = providerFeignApi;
    }

    @PostMapping(value = "/checkName")
    public String checkName(@RequestParam("un") String username){
        return this.providerFeignApi.checkName(username);
    }

    @PostMapping(value = "/addUser")
    public String addUser(User user){
        return this.providerFeignApi.addUser(user);
    }

    @PostMapping(value = "/login")
    public String loginUser(@RequestParam("un") String username,
                            @RequestParam("pwd") String password){
        return this.providerFeignApi.loginUser(username,password);
    }

    @GetMapping(value = "/query/{ticket}")
    public String queryTicket(@PathVariable("ticket") String ticket){
        return this.providerFeignApi.getTicket(ticket);
    }
}
