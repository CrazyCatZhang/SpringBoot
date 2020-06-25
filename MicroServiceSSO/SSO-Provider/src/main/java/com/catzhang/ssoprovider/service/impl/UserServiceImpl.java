package com.catzhang.ssoprovider.service.impl;

import com.catzhang.ssoprovider.mapper.UserMapper;
import com.catzhang.ssoprovider.pojo.User;
import com.catzhang.ssoprovider.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
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
        if (integer == 1){
            return 1;
        }else {
            return 0;
        }
    }

}
