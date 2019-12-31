package com.liu.dao;

import com.liu.domain.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAll();
}
