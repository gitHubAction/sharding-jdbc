package com.seven.sharding.service;

import com.seven.sharding.entity.Order;
import com.seven.sharding.repository.MybatisOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:    OrderService
 * Package:    com.seven.sharding.service
 * Datetime:    2020/8/31   11:08
 * Author:   zsh
 * Description:
 */
@Service
public class OrderService {
    @Autowired
    private MybatisOrderRepository orderRepository;

    @Transactional
    public void insert() {
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




    @Transactional
    public void insertBatch() {
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
        int l = 1/0;
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


    public void selectJoin(){
        List<Order> orders = orderRepository.selectJoin();
        for (Order o : orders) {
            System.out.println(o.toString());
        }
    }
}
