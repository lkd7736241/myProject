package com.sun.数据结构与算法.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by qiulisun on 2019/3/20.<br>
 */
public class HeadLine {
    public static void main(String[] args){
        Map<Long, List<Long>> map = new HashMap<>();

        List<Long> salesOrderIdList = new ArrayList<>();
        salesOrderIdList.add(1L);
        salesOrderIdList.add(2L);
        salesOrderIdList.add(3L);

        for (Long salesOrderId : salesOrderIdList) {
            List<Long> value = new ArrayList<>();
            map.put(salesOrderId, value);
        }

        for (Map.Entry<Long, List<Long>> entry : map.entrySet()) {
            List<Long> value = entry.getValue();
            value.add(111L);
            System.out.println(entry.getValue());
        }

        for (Map.Entry<Long, List<Long>> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        StringBuilder builder = new StringBuilder();
        List<Long> list = map.get(1L);
        builder.append("fail : deliveryHeaderId : ");
        for (Long aLong : list) {
            builder.append(aLong).append(",");
        }
        String string = builder.deleteCharAt(builder.length() - 1).toString();
        System.out.println(string);
    }
}
