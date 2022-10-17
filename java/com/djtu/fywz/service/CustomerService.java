package com.djtu.fywz.service;

import com.djtu.fywz.pojo.Customer;

public interface CustomerService extends CrudService<Customer>{

    /**
     * 返回登陆的用户
     * @param customer
     * @return
     */
    public Customer foreLogin(Customer customer);

    /**
     * 设置会员
     * @param id
     */
    public void shezhihuiyuan(int id);



}
