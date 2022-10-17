package com.djtu.fywz.pojo;

import java.util.List;

public class Order {
    private Integer id;
    private String code;//订单编号
    private String address;
    private Integer status;
    private Integer cstid;
    private Long bid;
    private String img;
    private List<OrderItem> orderItems;
    private Customer customer;
    //<editor-fold defaultstate="collapsed" desc="delombok">
    private float total; //总价
    private int totalNumber; //总数量
    //</editor-fold>

    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getCode() {
        return this.code;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public String getAddress() {
        return this.address;
    }

    @SuppressWarnings("all")
    public Integer getStatus() {
        return this.status;
    }

    @SuppressWarnings("all")
    public Integer getCstid() {
        return this.cstid;
    }

    @SuppressWarnings("all")
    public Long getBid() {
        return this.bid;
    }

    @SuppressWarnings("all")
    public String getImg() {
        return this.img;
    }

    @SuppressWarnings("all")
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    @SuppressWarnings("all")
    public Customer getCustomer() {
        return this.customer;
    }

    @SuppressWarnings("all")
    public float getTotal() {
        return this.total;
    }

    @SuppressWarnings("all")
    public int getTotalNumber() {
        return this.totalNumber;
    }

    @SuppressWarnings("all")
    public void setId(final Integer id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setCode(final String code) {
        this.code = code;
    }

    @SuppressWarnings("all")
    public void setAddress(final String address) {
        this.address = address;
    }

    @SuppressWarnings("all")
    public void setStatus(final Integer status) {
        this.status = status;
    }

    @SuppressWarnings("all")
    public void setCstid(final Integer cstid) {
        this.cstid = cstid;
    }

    @SuppressWarnings("all")
    public void setBid(final Long bid) {
        this.bid = bid;
    }

    @SuppressWarnings("all")
    public void setImg(final String img) {
        this.img = img;
    }

    @SuppressWarnings("all")
    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @SuppressWarnings("all")
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    @SuppressWarnings("all")
    public void setTotal(final float total) {
        this.total = total;
    }

    @SuppressWarnings("all")
    public void setTotalNumber(final int totalNumber) {
        this.totalNumber = totalNumber;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Order(id=" + this.getId() + ", code=" + this.getCode() + ", address=" + this.getAddress() + ", status=" + this.getStatus() + ", cstid=" + this.getCstid() + ", bid=" + this.getBid() + ", img=" + this.getImg() + ", orderItems=" + this.getOrderItems() + ", customer=" + this.getCustomer() + ", total=" + this.getTotal() + ", totalNumber=" + this.getTotalNumber() + ")";
    }
    //</editor-fold>
}
