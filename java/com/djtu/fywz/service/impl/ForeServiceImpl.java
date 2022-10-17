package com.djtu.fywz.service.impl;

import com.djtu.fywz.dao.CategoryMapper;
import com.djtu.fywz.dao.ProductMapper;
import com.djtu.fywz.pojo.Category;
import com.djtu.fywz.pojo.CategoryExample;
import com.djtu.fywz.pojo.Product;
import com.djtu.fywz.service.ForeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeServiceImpl implements ForeService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Category> listToThree() {
        CategoryExample example = new CategoryExample();
        example.createCriteria().andIdBetween(1,8); //从1开始计数
        List<Category> categories = categoryMapper.selectByExample(example);
        return categories;
    }

    @Override
    public List<Product> getFivePro() {
        return productMapper.randFive();
    }


}
