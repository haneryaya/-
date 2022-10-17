package com.djtu.fywz.pojo;

public class OrderItem {
    private Integer id;
    private Integer pid;
    private Integer oid;
    private Integer cstid;
    private Long bid;
    private Integer number;//购买数量
    //新增
    private Product product;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getId() {
        return this.id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Integer getPid() {
        return this.pid;
    }

    @SuppressWarnings("all")
    public Integer getOid() {
        return this.oid;
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
    public Integer getNumber() {
        return this.number;
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
    public void setPid(final Integer pid) {
        this.pid = pid;
    }

    @SuppressWarnings("all")
    public void setOid(final Integer oid) {
        this.oid = oid;
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
    public void setNumber(final Integer number) {
        this.number = number;
    }

    @SuppressWarnings("all")
    public void setProduct(final Product product) {
        this.product = product;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "OrderItem(id=" + this.getId() + ", pid=" + this.getPid() + ", oid=" + this.getOid() + ", cstid=" + this.getCstid() + ", bid=" + this.getBid() + ", number=" + this.getNumber() + ", product=" + this.getProduct() + ")";
    }
    //</editor-fold>
}
