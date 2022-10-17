package com.djtu.fywz.pojo;

public class Customer {
    private Integer id;
    private String name;
    private String password;
    private String address;
    private String phone;
    private Integer status;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "Customer(id=" + this.getId() + ", name=" + this.getName() + ", password=" + this.getPassword() + ", address=" + this.getAddress() + ", phone=" + this.getPhone() + ", status=" + this.getStatus() + ")";
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
    public void setPassword(final String password) {
        this.password = password;
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
    public void setStatus(final Integer status) {
        this.status = status;
    }

    @SuppressWarnings("all")
    public Integer getId() {
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
    public String getAddress() {
        return this.address;
    }

    @SuppressWarnings("all")
    public String getPhone() {
        return this.phone;
    }

    @SuppressWarnings("all")
    public Integer getStatus() {
        return this.status;
    }
    //</editor-fold>
}
