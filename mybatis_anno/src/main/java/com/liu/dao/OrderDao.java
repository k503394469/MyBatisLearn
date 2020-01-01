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
                    property = "user",//要封装的属性
                    javaType = User.class,//要封装属性的类型
                    column = "uid",//根据某个字段(uid,或者其他外键)去查询数据
                    //一对一,select 指的是通过column的值去查询另外一张表所对应的数据
                    one = @One(select = "com.liu.dao.UserDao.findById")
            )
    }
    )
    List<Order> findAll();
    @Select("select * from orders where uid=#{uid}")
    List<Order> findByUid(int uid);
}
