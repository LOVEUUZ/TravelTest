package com.example.uuz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class ResponseResultApplicationTests {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    // 列表右推入
    @Test
    public void test1(){
        String key = "zszxz1";
        String value = "知识追寻者";
        redisTemplate.opsForList().rightPush(key, value);
    }

    // 列表左推入
    @Test
    public void test2(){
        String key = "zszxz1";
        String value = "晴雨天";
        redisTemplate.opsForList().leftPush(key, value);
    }
    // 列表左弹出
    @Test
    public void test3(){
        String key = "zszxz";
        Object value = redisTemplate.opsForList().leftPop(key);
        // 晴雨天
        System.out.println(value);

    }
    // 列表右弹出
    @Test
    public void test4(){
        String key = "zszxz";
        Object value = redisTemplate.opsForList().rightPop(key);
        // 知识追寻者
        System.out.println(value);
    }

    // 将list右推入列表
    @Test
    public void test5(){
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        String key = "number";
        redisTemplate.opsForList().rightPushAll(key, list);
    }

    // 修改列表指定索引的值
    @Test
    public void test7(){
        String key = "number";
        int index = 0;
        int value = 666;
        redisTemplate.opsForList().set(key, index, value);
    }

    // 获取列表指定索引的值
    @Test
    public void test8(){
        String key = "number";
        int index = 0;
        Object value = redisTemplate.opsForList().index(key, index);
        // 666
        System.out.println(value);
    }
}
