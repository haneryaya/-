package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.Category;
import com.djtu.fywz.pojo.CategoryExample;

import java.util.List;

public interface CategoryMapper extends CrudDao<Category>{

     List<Category> selectByExample(CategoryExample example);

}