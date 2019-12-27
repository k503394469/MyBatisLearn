package com.liu;

import com.liu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    @Test
    public void test1() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        System.out.println(userList);
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("jjj");
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userMapper.save", user);
        sqlSession.commit();
        sqlSession.close();
    }

    //更新
    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setUsername("刘建东");
        user.setPassword("111");
        user.setId(1);
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("userMapper.update", user);
        sqlSession.commit();
        sqlSession.close();
    }
    //删除
    @Test
    public void test4() throws IOException {
        //加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取SqlSession会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("userMapper.delete",4);
        sqlSession.commit();
        sqlSession.close();
    }
}
