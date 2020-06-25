package com.catzhang.ssoprovider.mapper;

import com.catzhang.ssoprovider.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    public Boolean addUser(User user);

    public Integer checkUser(String username);

}

