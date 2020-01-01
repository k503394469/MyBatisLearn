package com.liu.dao;

import com.liu.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {
    @Select("select * from sys_role sr,sys_user_role sur where sr.id=sur.roleId and sur.userId=#{uid}")
    List<Role> findByUid(int uid);
}
