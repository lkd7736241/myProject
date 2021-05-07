package com.sun.annotation;

/**
 * create by qiulisun on 2020/12/7.<br>
 * @author 51050
 */
public class Apple {
    @FruitAnnotation(id = 1000, name = "红富士苹果", address = "山东")
    private String appleStr;

    public String getAppleStr() {
        return appleStr;
    }

    public void setAppleStr(String appleStr) {
        this.appleStr = appleStr;
    }
}
