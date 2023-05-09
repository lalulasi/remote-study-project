package com.lalulasi.springboot_nosql;

import com.lalulasi.springboot_nosq.dao.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-03-16 21:16
 **/
@SpringBootTest
public class MongoApplicationTest {

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    void insert(){
        User user = new User();
        String id = UUID.randomUUID().toString().replaceAll("-", "") + new Date().getTime();
        user.setId(id);
        user.setAge(20);
        user.setName("qq");
        mongoTemplate.save(user);
    }

    @Test
    void find(){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("qq"));
        User user = mongoTemplate.findOne(query, User.class);
        System.out.println(user);
    }
}
