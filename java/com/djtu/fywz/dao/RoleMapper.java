package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.Role;
import com.djtu.fywz.pojo.RoleExample;
import java.util.List;

public interface RoleMapper extends SysDao<Role> {

    List<Role> selectByExample(RoleExample example);

}