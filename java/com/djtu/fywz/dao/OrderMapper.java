package com.djtu.fywz.dao;

import com.djtu.fywz.pojo.Order;
import com.djtu.fywz.pojo.OrderExample;
import java.util.List;

public interface OrderMapper extends CrudDao<Order>{

    List<Order> selectByExample(OrderExample example);

}