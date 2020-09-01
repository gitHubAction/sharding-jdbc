package com.seven.sharding;

import com.seven.sharding.service.OrderService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.seven.sharding.repository"})
public class ShardingApplication {

    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(ShardingApplication.class, args);

        System.out.println("application is started");

        insert(app);

    }

    private static void insert(ConfigurableApplicationContext app) {
        OrderService orderService = app.getBean("orderService", OrderService.class);
        orderService.selectJoin();
    }

}
