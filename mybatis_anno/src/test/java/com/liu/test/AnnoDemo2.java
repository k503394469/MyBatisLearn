package com.liu.test;

import com.liu.dao.OrderDao;
import com.liu.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class AnnoDemo2 {
    private OrderDao orderDao;
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession(true);
        orderDao = sqlSession.getMapper(OrderDao.class);
    }
    @After
    public void des(){
        sqlSession.close();
    }
    @Test
    public void test1(){
        System.out.println(orderDao.findAll());
    }
}
