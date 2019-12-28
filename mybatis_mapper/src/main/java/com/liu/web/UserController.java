package com.liu.web;

import com.liu.domain.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;

import java.io.IOException;

public class UserController {
    public static void main(String[] args) throws IOException {
        UserService userService=new UserServiceImpl();
        //System.out.println(userService.findAll());
        //System.out.println(userService.findById(1));
        User user=new User();
        user.setId(1);
        user.setUsername("Αυ½¨Ά«");
        //user.setPassword("111");
        System.out.println(userService.findByCondition(user));
    }
}
