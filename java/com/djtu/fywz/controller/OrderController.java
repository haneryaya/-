package com.djtu.fywz.controller;


import com.djtu.fywz.pojo.*;
import com.djtu.fywz.service.OrderItemService;
import com.djtu.fywz.service.OrderService;
import com.djtu.fywz.service.ProductService;
import com.djtu.fywz.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单模块controller
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ProductService productService;



    @RequestMapping("/statistical")
    @ResponseBody
    public List<Statisticals> statistical(HttpSession session){

        Long id = (Long) session.getAttribute("id");
        OrderItem oi = new OrderItem();
        oi.setBid(id);
        List<Statistical> data = orderItemService.selectStatistical(oi);
        List<Statisticals> data1 = new ArrayList<>();
        for(Statistical statistical : data){
            Statisticals statisticals = new Statisticals();
            statisticals.setName(productService.get(statistical.getPid()).getName());
            statisticals.setValue(statistical.getValue());
            data1.add(statisticals);
        }
        System.out.println(data1);
        return data1;
    }




    /**
     * 所有订单
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, Page page, HttpSession session){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        OrderExample example = new OrderExample();
        Long id = (Long) session.getAttribute("id");
        System.out.println(id);
        if (id!=-1){
            example.createCriteria().andBidEqualTo(id);
        }
        List<Order> os= orderService.list(example);

        int total = (int) new PageInfo<>(os).getTotal();
        page.setTotal(total);
        //为订单添加订单项数据
        orderItemService.fill(os);

        model.addAttribute("os", os);
        model.addAttribute("page", page);
        model.addAttribute("totals", total);

        return "ordermodule/order-list";
    }

    /**
     * 订单发货
     * @param o
     * @return
     */
    @RequestMapping("/orderDelivery")
    public String delivery(Order o){
        o.setStatus(2);
        orderService.update(o);
        return "redirect:list";
    }

    /**
     * 查看当前订单的订单项
     * @param oid
     * @param model
     * @return
     */
    @RequestMapping("/seeOrderItem")
    public String seeOrderItem(int oid,Model model){
        Order o = orderService.get(oid);
        orderItemService.fill(o);
        model.addAttribute("orderItems",o.getOrderItems());
        model.addAttribute("total",o.getOrderItems().size());
        model.addAttribute("totalPrice",o.getTotal());
        return "ordermodule/orderItem-list";
    }

}
