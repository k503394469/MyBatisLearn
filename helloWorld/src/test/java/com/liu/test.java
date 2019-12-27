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
        //���غ��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //��ȡSqlSession��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //��ȡSqlSession�Ự����
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
        //���غ��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //��ȡSqlSession��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //��ȡSqlSession�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userMapper.save", user);
        sqlSession.commit();
        sqlSession.close();
    }

    //����
    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setUsername("������");
        user.setPassword("111");
        user.setId(1);
        //���غ��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //��ȡSqlSession��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //��ȡSqlSession�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("userMapper.update", user);
        sqlSession.commit();
        sqlSession.close();
    }
    //ɾ��
    @Test
    public void test4() throws IOException {
        //���غ��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //��ȡSqlSession��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //��ȡSqlSession�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("userMapper.delete",4);
        sqlSession.commit();
        sqlSession.close();
    }
}
