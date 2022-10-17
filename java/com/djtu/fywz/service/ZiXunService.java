package com.djtu.fywz.service;

import com.djtu.fywz.pojo.ZiXun;

import java.util.List;

/**
 * 留言
 */
public interface ZiXunService extends CrudService<ZiXun> {

    /**
     * 留言审核通过
     * @param zid
     */
    void shenhe(int zid);

    /**
     * 连带未审核的留言
     * @return
     */
    List<ZiXun> list1();

}
