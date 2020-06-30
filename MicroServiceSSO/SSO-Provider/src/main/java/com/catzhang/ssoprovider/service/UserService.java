package com.catzhang.ssoprovider.service;

import com.catzhang.ssoprovider.pojo.User;

public interface UserService {

    public Boolean addUser(User user);

    public Integer checkUser(String username);

    public String loginUser(String username,String password);

    public String getUserInfo(String tickets);
}
