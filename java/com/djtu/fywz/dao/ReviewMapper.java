package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.Review;
import com.djtu.fywz.pojo.ReviewExample;
import java.util.List;

public interface ReviewMapper extends CrudDao<Review>{

    List<Review> selectByExample(ReviewExample example);

}