package com.liu.service.impl;

import com.liu.dao.UserDao;
import com.liu.dao.impl.UserDaoImpl;
import com.liu.domain.User;
import com.liu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
