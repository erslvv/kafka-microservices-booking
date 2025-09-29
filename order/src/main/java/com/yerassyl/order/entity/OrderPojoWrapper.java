package com.yerassyl.order.entity;

import com.yerassyl.common.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderPojoWrapper {
    private List<Order> orders;
}
