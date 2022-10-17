package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.OrderItem;
import com.djtu.fywz.pojo.OrderItemExample;
import com.djtu.fywz.pojo.Statistical;

import java.util.List;

public interface OrderItemMapper extends CrudDao<OrderItem>{

    List<OrderItem> selectByExample(OrderItemExample example);

    List<Statistical> selectStatistical(OrderItem oi);

}