package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.UserRole;
import com.djtu.fywz.pojo.UserRoleExample;

import java.util.List;

public interface UserRoleMapper extends SysDao<UserRole>{

    List<UserRole> selectByExample(UserRoleExample example);

}