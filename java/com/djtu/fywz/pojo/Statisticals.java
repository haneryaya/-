package com.djtu.fywz.pojo;

public class Statisticals {

    private Integer value;

    private String name;



    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Statistical{" +
                "value=" + value +
                ", name='" + name + '\'' +

                '}';
    }
}