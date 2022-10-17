package com.djtu.fywz.service.impl;

import com.djtu.fywz.dao.ProductMapper;
import com.djtu.fywz.dao.UserMapper;
import com.djtu.fywz.pojo.*;
import com.djtu.fywz.service.CategoryService;
import com.djtu.fywz.service.ProductService;
import com.djtu.fywz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Product> list(ProductExample example) {
        List<Product> products = productMapper.selectByExample(example);//获得宠物列表
        for (Product p:products){
            Category category = categoryService.get(p.getCid());
            p.setCategory(category);
            User user = userService.get(p.getBid());
            p.setUser(user);
        }
        return products;
    }

    @Override
    public String enableStatus(String name) {
        productMapper.enableStatus(name);
        return "success";
    }

    @Override
    public String stopStatus(String name) {
        productMapper.stopStatus(name);
        return "success";
    }

    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public void save(Product product) {
        product.setStatus(1);
        productMapper.insert(product);
    }

    @Override
    public void setImageURL(ProductVO vo) {
        productMapper.setImageUrl(vo);
    }

    @Override
    public Product get(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void del(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category getCategoryByCid(int id) {
        Category category = categoryService.get(id);
        return category;
    }

    @Override
    public void update(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public List<Product> getProductsByCid(Integer id) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(id).andStatusEqualTo(1);
        return productMapper.selectByExample(example);
    }




    @Override
    public User getUserByBid(long id) {
        return  userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Product> findByName(String pName) {
        ProductExample example = new ProductExample();
        example.createCriteria().andNameLike("%"+pName+"%");
        List<Product> products = productMapper.selectByExample(example);
        return products;
    }

    @Override
    public List<Product> findByCid(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        List<Product> products = productMapper.selectByExample(example);
        return products;
    }

    @Override
    public boolean findProByCid(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        List<Product> products = productMapper.selectByExample(example);
        return products.size()>0&&products!=null?true:false;
    }

}
