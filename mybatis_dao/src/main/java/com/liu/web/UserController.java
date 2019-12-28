package com.liu.web;

import com.liu.domain.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;

import java.util.List;

public class UserController {
    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        List<User> userList = userService.findAll();
        System.out.println(userList);
    }
}
