package com.lalulasi.springboot_nosql;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @program: springboot
 * @description:
 * @author: jun.luo
 * @create: 2023-03-17 20:20
 **/

@SpringBootTest
public class ESApplicationTest {
    @Value("${elasticsearch.uris")
    private String host;


    void createIndex(){
        RestClient client = RestClient.builder(new HttpHost(host, 9200)).build();
    }


}
