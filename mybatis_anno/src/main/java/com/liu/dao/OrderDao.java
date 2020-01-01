package com.liu.dao;

import com.liu.domain.Order;
import com.liu.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {
    @Select("select * , o.id oid from orders o,user u where o.uid=u.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            //@Result(column = "uid", property = "user.id"),
            //@Result(column = "username", property = "user.username"),
            //@Result(column = "password", property = "user.password"),
            //@Result(column = "birthday", property = "user.birthday"),
            @Result(
                    property = "user",//Ҫ��װ������
                    javaType = User.class,//Ҫ��װ���Ե�����
                    column = "uid",//����ĳ���ֶ�(uid,�����������)ȥ��ѯ����
                    //һ��һ,select ָ����ͨ��column��ֵȥ��ѯ����һ�ű�����Ӧ������
                    one = @One(select = "com.liu.dao.UserDao.findById")
            )
    }
    )
    List<Order> findAll();
    @Select("select * from orders where uid=#{uid}")
    List<Order> findByUid(int uid);
}
