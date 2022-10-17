package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.Product;
import com.djtu.fywz.pojo.ProductExample;
import com.djtu.fywz.pojo.ProductVO;

import java.util.List;

public interface ProductMapper extends CrudDao<Product>{

    List<Product> selectByExample(ProductExample example);

    /**
     * 宠物上线
     * @param name
     */
    void enableStatus(String name);

    /**
     * 宠物下线
     * @param name
     */
    void stopStatus(String name);

    /**
     * 设置图片保存的位置
     * @param vo
     */
    void setImageUrl(ProductVO vo);

    /**
     * 随机五条宠物
     * @return
     */
    List<Product> randFive();

    boolean findProByCid(int cid);

}