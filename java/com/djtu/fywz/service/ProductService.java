package com.djtu.fywz.service;

import com.djtu.fywz.pojo.*;

import java.util.List;

public interface ProductService extends CrudService<Product>{


    public List<Product> list(ProductExample example);


    /**
     * 宠物上线
     * @param name
     * @return
     */
   public String enableStatus(String name);

    /**
     * 宠物下线
     * @param name
     * @return
     */
   public String stopStatus(String name);

    /**
     * 设置宠物图片保存位置
     * @param vo
     */
   public void setImageURL(ProductVO vo);

    /**
     * 获得分类实体
     * @param id 分类id
     * @return
     */
   public Category getCategoryByCid(int id);

    /**
     * 更新宠物
     * @param product
     */
   public void update(Product product);

    /**
     *  获取分类下的所有上线宠物列表
     * @param id
     * @return
     */
   public List<Product> getProductsByCid(Integer id);



    /**
     * 获得宠物所属商家/主人
     * @param id 商家/主人id
     * @return
     */
   public User getUserByBid(long id);

    /**
     * 模糊搜索
     * @param pName 宠物name
     * @return 宠物集合
     */
   public List<Product> findByName(String pName);

    /**
     *
     * @param cid
     * @return
     */
   public List<Product> findByCid(int cid);

   public boolean findProByCid(int id);

}
