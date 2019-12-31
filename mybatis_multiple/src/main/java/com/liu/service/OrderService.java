package com.liu.service;

import com.liu.dao.OrderDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class OrderService {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        System.out.println(orderDao.findAll());
        sqlSession.close();
    }
}
