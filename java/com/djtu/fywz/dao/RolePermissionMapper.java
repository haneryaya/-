package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.RolePermission;
import com.djtu.fywz.pojo.RolePermissionExample;
import java.util.List;

public interface RolePermissionMapper extends SysDao<RolePermission>{

    List<RolePermission> selectByExample(RolePermissionExample example);

}