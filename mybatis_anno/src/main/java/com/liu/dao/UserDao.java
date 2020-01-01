package com.liu.dao;

import com.liu.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    List<User> findAll();
    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    void save(User user);
    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    void update(User user);
    @Delete("delete from user where id=#{id}")
    void delete(int id);
    @Select("select * from user where id=#{id}")
    User findById(int id);
    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(
                    column = "id",//����ĳ���ֶ�(id,�����������)ȥ��ѯ����
                    javaType = List.class,//��װ��������
                    property = "orderList",//����ֵ
                    //һ�Զ�,ͨ��id��ѯ����һ�ű�
                    many = @Many(select = "com.liu.dao.OrderDao.findByUid")

            )
    })
    List<User> findUserAndOrder();
    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(
                    column = "id",//����ĳ���ֶ�(id,�����������)ȥ��ѯ����
                    javaType = List.class,//��װ��������
                    property = "roleList",//����ֵ
                    //һ�Զ�,ͨ��id��ѯ����һ�ű�
                    many = @Many(select = "com.liu.dao.RoleDao.findByUid")

            )
    })
    List<User> findUserAndRole();

}
