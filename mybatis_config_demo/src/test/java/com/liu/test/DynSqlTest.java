package com.liu.test;

import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;
import org.junit.Test;

public class DynSqlTest {
    @Test
    public void test1() throws Exception {
        UserService userService=new UserServiceImpl();
        System.out.println(userService.findAll());
    }
}
