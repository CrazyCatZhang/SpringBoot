package com.catzhang.ssoprovider.service.impl;

import com.catzhang.ssoprovider.mapper.UserMapper;
import com.catzhang.ssoprovider.pojo.User;
import com.catzhang.ssoprovider.service.UserService;
import com.catzhang.ssoprovider.utils.RedisAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final RedisAPI redisAPI;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    public UserServiceImpl(UserMapper userMapper, RedisAPI redisAPI) {
        this.userMapper = userMapper;
        this.redisAPI = redisAPI;
    }

    @Override
    public Boolean addUser(User user) {
        final String newPassword = DigestUtils.md5Hex(user.getPassword());
        user.setPassword(newPassword);
        final Integer integer = this.userMapper.checkUser(user.getUsername());
        if (integer == 1) {
            return false;
        } else {
            this.userMapper.addUser(user);
            return true;
        }
    }

    @Override
    public Integer checkUser(String username) {
        final Integer integer = this.userMapper.checkUser(username);
        if (integer == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String loginUser(String username, String password) {
        String ticket = null;
        password = DigestUtils.md5Hex(password);
        User user = this.userMapper.loginUser(username, password);
        if (user != null) {
            ticket = DigestUtils.md5Hex("myticket" + System.currentTimeMillis() + username);
            try {
                String userJson = MAPPER.writeValueAsString(user);
                this.redisAPI.set(ticket, userJson, 60 * 60 * 24 * 7);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return "操作Redis时候出现了系统异常";
            }
        }
        return "success";
    }

    @Override
    public String getUserInfo(String tickets) {
        return redisAPI.get(tickets);
    }

}
