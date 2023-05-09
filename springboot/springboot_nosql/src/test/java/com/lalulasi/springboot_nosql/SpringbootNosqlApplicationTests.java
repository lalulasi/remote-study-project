package com.lalulasi.springboot_nosql;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootNosqlApplicationTests {

    @Resource // 这里无法使用Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void set(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("age", "89");

    }

    @Test
    void get(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        System.out.println(ops.get("age"));
    }

    @Test
    void hset(){
        HashOperations<String, String, String> ops = redisTemplate.opsForHash();
        ops.put("info", "user", "admin");
    }

    @Test
    void hget(){
        HashOperations<String, String, String> ops = redisTemplate.opsForHash();
        System.out.println(ops.get("info", "user"));
    }
}
