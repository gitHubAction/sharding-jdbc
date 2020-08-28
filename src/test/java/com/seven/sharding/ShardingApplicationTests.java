package com.seven.sharding;

import com.seven.sharding.entity.Order;
import com.seven.sharding.repository.MybatisOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShardingApplicationTests {

    @Autowired
    private MybatisOrderRepository orderRepository;

    @Test
    void contextLoads() {
        List<Order> orders = orderRepository.selectAll();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

}
