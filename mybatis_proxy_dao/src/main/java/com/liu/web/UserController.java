package com.liu.web;

import com.liu.dao.UserDao;
import com.liu.domain.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserController {
    public static void main(String[] args) throws IOException {
        UserService userService=new UserServiceImpl();
        System.out.println(userService.findAll());
        System.out.println(userService.findById(1));
    }
}
