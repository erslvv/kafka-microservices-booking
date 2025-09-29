package com.yerassyl.payment;

import com.yerassyl.common.entity.Order;
import com.yerassyl.payment.service.OrderPaymentManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@ComponentScan(basePackages = "com.yerassyl")
@EnableKafka
@Slf4j
public class PaymentApplication {

    private final OrderPaymentManagementService orderManagementService;

    public PaymentApplication(OrderPaymentManagementService orderManagementService) {
        this.orderManagementService = orderManagementService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @KafkaListener(topics = "${topic.name.order}")
    private void listener(Order order) {
        orderManagementService.processPayment(order);
    }
}