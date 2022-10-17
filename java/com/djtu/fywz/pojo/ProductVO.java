package com.djtu.fywz.pojo;

/**
 * 传入宠物id和url封装
 */
public class ProductVO {
    private int id;
    private String imageUrl;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public int getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getImageUrl() {
        return this.imageUrl;
    }

    @SuppressWarnings("all")
    public void setId(final int id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "ProductVO(id=" + this.getId() + ", imageUrl=" + this.getImageUrl() + ")";
    }
    //</editor-fold>
}
