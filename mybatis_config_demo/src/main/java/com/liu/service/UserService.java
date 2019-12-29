package com.liu.service;

import com.liu.domain.User;

import java.util.List;

public interface UserService {
    void save(User user) throws Exception;
    User findById(int id) throws Exception;
    List<User> findAll() throws Exception;

}
