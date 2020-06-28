package com.catzhang.ssoprovider.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisAPI {

    private final RedisTemplate<String,String> redisTemplate;

    @Autowired
    public RedisAPI(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key,String value){
        this.redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key,String value,Integer seconds){
        this.redisTemplate.opsForValue().set(key,value);
        this.redisTemplate.expire(key,seconds, TimeUnit.SECONDS);
    }

    public void expire(String key,Integer seconds){
        this.redisTemplate.expire(key,seconds,TimeUnit.SECONDS);
    }

    public String get(String key){
        return this.redisTemplate.opsForValue().get(key).toString();
    }
}
