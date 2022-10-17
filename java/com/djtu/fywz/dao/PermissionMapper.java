package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.Permission;
import com.djtu.fywz.pojo.PermissionExample;
import java.util.List;

public interface PermissionMapper extends SysDao<Permission>{

    List<Permission> selectByExample(PermissionExample example);

}