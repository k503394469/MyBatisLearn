package com.liu.service;

import com.liu.dao.OrderDao;
import com.liu.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserService {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //System.out.println(userDao.findAll());
        System.out.println(userDao.userAndRole());
        sqlSession.close();
    }
}
