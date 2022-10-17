package com.djtu.fywz.pojo;

public class Product {
    private Integer id;
    private String name;
    private Float price;
    private String zan;
    private String number;
    private Integer status;
    private String imageurl;
    private String miaoshu;
    private Integer cid;
    private Long bid;
    private Integer recipe;
    //<editor-fold defaultstate="collapsed" desc="delombok">
    private Category category;
    private User user;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public String getName() {
        return this.name;
    }
    //</editor-fold>

    @SuppressWarnings("all")
    public Float getPrice() {
        return this.price;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public String getZan() {
        return this.zan;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public String getNumber() {
        return this.number;
    }

    @SuppressWarnings("all")
    public Integer getStatus() {
        return this.status;
    }

    @SuppressWarnings("all")
    public String getImageurl() {
        return this.imageurl;
    }

    @SuppressWarnings("all")
    public String getMiaoshu() {
        return this.miaoshu;
    }

    @SuppressWarnings("all")
    public Integer getCid() {
        return this.cid;
    }

    @SuppressWarnings("all")
    public Long getBid() {
        return this.bid;
    }

    @SuppressWarnings("all")
    public Integer getRecipe() {
        return this.recipe;
    }

    @SuppressWarnings("all")
    public Category getCategory() {
        return this.category;
    }

    @SuppressWarnings("all")
    public User getUser() {
        return this.user;
    }

    @SuppressWarnings("all")
    public void setId(final Integer id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    public void setPrice(final Float price) {
        this.price = price;
    }

    @SuppressWarnings("all")
    public void setZan(final String zan) {
        this.zan = zan;
    }

    @SuppressWarnings("all")
    public void setNumber(final String number) {
        this.number = number;
    }

    @SuppressWarnings("all")
    public void setStatus(final Integer status) {
        this.status = status;
    }

    @SuppressWarnings("all")
    public void setImageurl(final String imageurl) {
        this.imageurl = imageurl;
    }

    @SuppressWarnings("all")
    public void setMiaoshu(final String miaoshu) {
        this.miaoshu = miaoshu;
    }

    @SuppressWarnings("all")
    public void setCid(final Integer cid) {
        this.cid = cid;
    }

    @SuppressWarnings("all")
    public void setBid(final Long bid) {
        this.bid = bid;
    }

    @SuppressWarnings("all")
    public void setRecipe(final Integer recipe) {
        this.recipe = recipe;
    }

    @SuppressWarnings("all")
    public void setCategory(final Category category) {
        this.category = category;
    }

    @SuppressWarnings("all")
    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Product(id=" + this.getId() + ", name=" + this.getName() + ", price=" + this.getPrice() + ", zan=" + this.getZan() + ", number=" + this.getNumber() + ", status=" + this.getStatus() + ", imageurl=" + this.getImageurl() + ", miaoshu=" + this.getMiaoshu() + ", cid=" + this.getCid() + ", bid=" + this.getBid() + ", recipe=" + this.getRecipe() + ", category=" + this.getCategory() + ", user=" + this.getUser() + ")";
    }
    //</editor-fold>
}
