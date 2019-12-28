package com.liu.test;

import com.liu.dao.UserDao;
import com.liu.domain.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DynSqlTest {
    @Test
    public void test1(){
        UserService userService=new UserServiceImpl();
        //User user=new User();
        //user.setId(1);
        //user.setUsername("Αυ½¨Ά«");
        //user.setPassword("111");
        //System.out.println(userService.findByCondition(user));
        List<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<User> byIds = userService.findByIds(ids);
        System.out.println(byIds);
    }
}
