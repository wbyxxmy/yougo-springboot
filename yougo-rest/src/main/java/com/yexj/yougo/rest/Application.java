package com.yexj.yougo.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by xinjian.ye on 2017/8/18.
 */
@SpringBootApplication(exclude = {SessionAutoConfiguration.class, DataSourceAutoConfiguration.class, RedisAutoConfiguration.class})
@ImportResource({"classpath*:spring/applicationContext-*.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
