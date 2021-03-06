package com.seven.sharding;

import com.seven.sharding.entity.Order;
import com.seven.sharding.repository.MybatisOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShardingApplicationTests {

    @Autowired
    private MybatisOrderRepository orderRepository;

    @Test
    void queryAll() {
        List<Order> orders = orderRepository.selectAll();
        for (Order order : orders) {
            System.out.println(order);
        }
    }


    @Test
    @Transactional
    void insert() {
        List<Long> ids = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            Order o = new Order();
            o.setUserId(i);
            o.setStatus("0");
            if(i == 11){
                int k = 1/0;
            }
            Long id = orderRepository.insert(o);
            ids.add(id);
        }
        System.out.println("---------------------");
        List<Order> orders = orderRepository.selectByOrderID(ids);
        for (Order o : orders) {
            System.out.println(o.toString());
        }
    }



    @Test
//    @ShardingTransactionType(TransactionType.BASE)
    @Transactional
    void insertBatch() {
        List<Order> ordersEve = new ArrayList<>();
        for (int i = 2; i < 20; i+=2) {
            Order o = new Order();
            o.setUserId(i);
            o.setStatus("Insert_batch");
            ordersEve.add(o);
        }
        Integer cnt = orderRepository.insertBatch(ordersEve);
        System.out.println("---------------------"+cnt);
        for (Order o : ordersEve) {
            System.out.println(o.getOrderId());
        }

        System.out.println("Odd insert start----------");

        List<Order> orders = new ArrayList<>();
        for (int i = 1; i < 20; i+=2) {
            Order o = new Order();
            o.setUserId(i);
            o.setStatus("Insert_batch");
            orders.add(o);
        }
        Integer cntE = orderRepository.insertBatch(orders);
        System.out.println("---------------------"+cntE);
        for (Order o : orders) {
            System.out.println(o.getOrderId());
        }

    }

}
