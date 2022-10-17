package com.djtu.fywz.pojo;

import java.util.List;

public class Statistical {

    private Integer value;

    private String name;

    private Integer pid;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Statistical{" +
                "value=" + value +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                '}';
    }
}