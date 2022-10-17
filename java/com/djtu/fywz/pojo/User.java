package com.djtu.fywz.pojo;

import java.util.Date;

public class User {
    private Long id;
    private String name;
    private String password;
    private String salt;
    private Integer status;
    private String address;
    private String phone;
    private Date lasttime;
    private String shopid;
    private String img;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    public void setPassword(final String password) {
        this.password = password;
    }

    @SuppressWarnings("all")
    public void setSalt(final String salt) {
        this.salt = salt;
    }

    @SuppressWarnings("all")
    public void setStatus(final Integer status) {
        this.status = status;
    }

    @SuppressWarnings("all")
    public void setAddress(final String address) {
        this.address = address;
    }

    @SuppressWarnings("all")
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @SuppressWarnings("all")
    public void setLasttime(final Date lasttime) {
        this.lasttime = lasttime;
    }

    @SuppressWarnings("all")
    public void setShopid(final String shopid) {
        this.shopid = shopid;
    }

    @SuppressWarnings("all")
    public void setImg(final String img) {
        this.img = img;
    }

    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    public String getPassword() {
        return this.password;
    }

    @SuppressWarnings("all")
    public String getSalt() {
        return this.salt;
    }

    @SuppressWarnings("all")
    public Integer getStatus() {
        return this.status;
    }

    @SuppressWarnings("all")
    public String getAddress() {
        return this.address;
    }

    @SuppressWarnings("all")
    public String getPhone() {
        return this.phone;
    }

    @SuppressWarnings("all")
    public Date getLasttime() {
        return this.lasttime;
    }

    @SuppressWarnings("all")
    public String getShopid() {
        return this.shopid;
    }

    @SuppressWarnings("all")
    public String getImg() {
        return this.img;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "User(id=" + this.getId() + ", name=" + this.getName() + ", password=" + this.getPassword() + ", salt=" + this.getSalt() + ", status=" + this.getStatus() + ", address=" + this.getAddress() + ", phone=" + this.getPhone() + ", lasttime=" + this.getLasttime() + ", shopid=" + this.getShopid() + ", img=" + this.getImg() + ")";
    }
    //</editor-fold>
}
