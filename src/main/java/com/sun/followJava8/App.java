package com.sun.followJava8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * create by qiulisun on 2019/5/2.<br>
 */
public class App {
    public static void main(String[] args){
        ShopProperty p1 = new ShopProperty("叫了个鸡", 1000, 50.0);
        ShopProperty p2 = new ShopProperty("张三丰饺子馆", 2300, 70.0);
        ShopProperty p3 = new ShopProperty("永和大王", 580, 40.0);
        ShopProperty p4 = new ShopProperty("麦当劳", 6000, 80.0);
        List<ShopProperty> shopProperties = Arrays.asList(p1, p2, p3, p4);
//        Collections.sort(shopProperties, (x, y) -> x.getDistance().compareTo(y.getDistance()));
//        String name = shopProperties.get(0).getName();
        String name = shopProperties.stream().sorted(Comparator.comparing(x -> x.getDistance())).
                findFirst().get().getName();
        System.out.println("距我最近的店铺是：" + name);

//        Stream<String> stringStream = shopProperties.stream().map(p -> p.getName());
//        System.out.println(stringStream);

        /** 获取每个店铺的价格 map<名称，价格> </> */
//        Map<String, Double> shopPropertyMap = shopProperties.stream()
//                .collect(Collectors.toMap(ShopProperty::getName, ShopProperty::setPrice));
//        for (Map.Entry<String, Double> entry : shopPropertyMap.entrySet()) {
//            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
//        }


    }
}
