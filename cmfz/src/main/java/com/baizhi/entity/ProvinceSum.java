package com.baizhi.entity;

/**
 * Created by he on 2018/6/1.
 * 省份的格式  name / value
 *
 */
public class ProvinceSum {
    private String name;
    private String value;

    public ProvinceSum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public ProvinceSum() {
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

    @Override
    public String toString() {
        return "ProvinceSum{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
