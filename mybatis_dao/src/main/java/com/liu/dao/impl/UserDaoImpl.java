package com.liu.dao.impl;

import com.liu.dao.UserDao;
import com.liu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSession sqlSession = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession();
            List<User> userList = sqlSession.selectList("userMapper.findAll");
            return userList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
