package com.hzlgit.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void set(){
        this.redisTemplate.opsForValue().set("days",12);
        System.out.println("set redisTemplate=="+(redisTemplate.opsForValue().get("days")));
    }

    @Test
    public void get(){
        System.out.println("get redisTemplate=="+(redisTemplate.opsForValue().get("days")));
    }
}
