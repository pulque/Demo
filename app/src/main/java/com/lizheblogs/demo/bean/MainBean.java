package com.lizheblogs.demo.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by LiZhe on 2019-09-27.
 * com.lizheblogs.demo.bean
 */
public class MainBean {

    /*
    name, --字段名称
    value, --描述
    cls, --页面
     */
    @Expose
    @SerializedName(value = "name", alternate = {"Name"})
    private String name;
    @Expose
    @SerializedName(value = "value", alternate = {"Value"})
    private String value;
    private Class<?> cls;

    public MainBean(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public MainBean(String name, String value, Class<?> cls) {
        this.name = name;
        this.value = value;
        this.cls = cls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }
}
