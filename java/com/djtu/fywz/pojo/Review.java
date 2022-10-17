package com.djtu.fywz.pojo;

import java.util.Date;

public class Review {
    private Integer id;
    private String content;
    private Integer cstid;
    private Integer pid;
    private Date createtime;
    private Customer customer;
    private Product product;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getContent() {
        return this.content;
    }

    @SuppressWarnings("all")
    public Integer getCstid() {
        return this.cstid;
    }

    @SuppressWarnings("all")
    public Integer getPid() {
        return this.pid;
    }

    @SuppressWarnings("all")
    public Date getCreatetime() {
        return this.createtime;
    }

    @SuppressWarnings("all")
    public Customer getCustomer() {
        return this.customer;
    }

    @SuppressWarnings("all")
    public Product getProduct() {
        return this.product;
    }

    @SuppressWarnings("all")
    public void setId(final Integer id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setContent(final String content) {
        this.content = content;
    }

    @SuppressWarnings("all")
    public void setCstid(final Integer cstid) {
        this.cstid = cstid;
    }

    @SuppressWarnings("all")
    public void setPid(final Integer pid) {
        this.pid = pid;
    }

    @SuppressWarnings("all")
    public void setCreatetime(final Date createtime) {
        this.createtime = createtime;
    }

    @SuppressWarnings("all")
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    @SuppressWarnings("all")
    public void setProduct(final Product product) {
        this.product = product;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Review(id=" + this.getId() + ", content=" + this.getContent() + ", cstid=" + this.getCstid() + ", pid=" + this.getPid() + ", createtime=" + this.getCreatetime() + ", customer=" + this.getCustomer() + ", product=" + this.getProduct() + ")";
    }
    //</editor-fold>
}
