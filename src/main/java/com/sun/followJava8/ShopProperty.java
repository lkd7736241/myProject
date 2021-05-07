package com.sun.followJava8;

/**
 * create by qiulisun on 2019/5/2.<br>
 */
public class ShopProperty {
    private String name;
    private Integer distance;
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ShopProperty(String name, Integer distance, Double price) {
        this.name = name;
        this.distance = distance;
        this.price = price;
    }
}
