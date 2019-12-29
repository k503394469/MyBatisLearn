package com.liu.dao;

import com.liu.domain.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    User findById(int id);
    List<User> findAll();
}
