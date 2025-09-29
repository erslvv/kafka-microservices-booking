package com.yerassyl.order.service;

import com.yerassyl.order.entity.OrderDAO;
import com.yerassyl.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDAO save(OrderDAO orderDAO){
        return orderRepository.save(orderDAO);
    }

    public <S extends OrderDAO> Iterable<S> saveAll(Iterable<S> entities) {
        return orderRepository.saveAll(entities);
    }

    public Optional<OrderDAO> findByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);
    }
}
