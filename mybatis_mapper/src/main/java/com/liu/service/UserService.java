package com.liu.service;

import com.liu.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    User findByCondition(User user);
    List<User> findByIds(List<Integer> ids);
}
