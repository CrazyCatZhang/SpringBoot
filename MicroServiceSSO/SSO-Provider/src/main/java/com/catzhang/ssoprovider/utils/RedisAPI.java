package com.catzhang.ssoprovider.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisAPI {

    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public RedisAPI(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //1.设置值
    public void set(String key , String value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    //2.设置值，以及过期时间
    public void set(String key,String value , Integer seconds ) {
        //设置值
        this.redisTemplate.opsForValue().set(key, value);
        //设置过期时间
        this.redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    //3.针对 key 设置过期时间
    public void expire(String key , Integer seconds) {
        this.redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    //4.获取数据
    public String get(String key) {
        return this.redisTemplate.opsForValue().get(key).toString();
    }
}
