package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.ZiXun;
import com.djtu.fywz.pojo.ZiXunExample;
import java.util.List;

public interface ZiXunMapper extends CrudDao<ZiXun> {

    List<ZiXun> selectByExample(ZiXunExample example);

    /**
     * 留言审核
     * @param zid
     */
    void shenhe(int zid);

}