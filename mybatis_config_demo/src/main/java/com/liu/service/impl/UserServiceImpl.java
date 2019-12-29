package com.liu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.liu.dao.UserDao;
import com.liu.domain.User;
import com.liu.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.save(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findById(int id) throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user=userDao.findById(id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findAll() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //设置分页参数(当前页数,每页个数)
        PageHelper.startPage(2,1);
        List<User> userList = userDao.findAll();
        //与分页相关参数
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        System.out.println(userPageInfo.getTotal());
        sqlSession.close();
        return userList;
    }
}
