package com.djtu.fywz.service;

import com.djtu.fywz.pojo.Review;

import java.util.List;

public interface ReviewService extends CrudService<Review>{

    /**
     * 获得一个宠物的所有评论
     * @param id 宠物id
     * @return
     */
    List<Review> getReviewListByPid(int id);

}
