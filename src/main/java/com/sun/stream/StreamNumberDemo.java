package com.sun.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create by qiulisun on 2019/3/3.<br>
 */
public class StreamNumberDemo {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println("----- Java 7 -----");
        System.out.println("使用 Java 7；列表:" + numbers);
        // 获取列表元素平方数
        List<Integer> squares7 = getSquares(numbers);
        System.out.println("使用 Java 7；获取列表元素平方数:" + squares7);

        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

        System.out.println("使用 Java 7；列表: " + integers);
        System.out.println("使用 Java 7；列表中最大的数 : " + getMax(integers));
        System.out.println("使用 Java 7；列表中最小的数 : " + getMin(integers));
        System.out.println("使用 Java 7；所有数之和 : " + getSum(integers));
        System.out.println("使用 Java 7；平均数 : " + getAverage(integers));

        System.out.println("----- Java 8 -----");
        System.out.println("使用 Java 8；列表:" + numbers);
        // 获取列表元素平方数
        List<Integer> squeres8 = numbers.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println("使用 Java 8；获取列表元素平方数:" + squeres8);

        System.out.println("使用 Java 8；列表: " + integers);
        IntSummaryStatistics statistics = integers.stream().mapToInt((n) -> n).summaryStatistics();
        System.out.println("使用 Java 8；列表: " + integers);
        System.out.println("使用 Java 8；列表中最大的数 : " + statistics.getMax());
        System.out.println("使用 Java 8；列表中最小的数 : " + statistics.getMin());
        System.out.println("使用 Java 8；所有数之和 : " + statistics.getSum());
        System.out.println("使用 Java 8；平均数 : " + statistics.getAverage());
    }

    /**
     * 获取数组平均值
     * @param integers
     * @return
     */
    private static double getAverage(List<Integer> integers) {
        Double result = 0.0;
        int sum = 0;
        int count = 0;
        for (Integer integer : integers) {
            sum += integer;
            count++;
        }
        result = Double.valueOf(sum/count);
        return result;
    }

    /**
     * 获取数组总和
     * @param integers
     * @return
     */
    private static int getSum(List<Integer> integers) {
        int result = 0;
        for (Integer integer : integers) {
            result += integer;
        }
        return result;
    }

    /**
     * 获取数组最小值
     * @param integers
     * @return
     */
    private static int getMin(List<Integer> integers) {
        int result = integers.get(0);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) < result) {
            	result = integers.get(i);
            }
        }
        return result;
    }

    /**
     * 获取数组最大值
     * @param integers
     * @return
     */
    private static int getMax(List<Integer> integers) {
        int result = 0;
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) >= result) {
            	result = integers.get(i);
            }
        }
        return result;
    }

    /**
     * 获取数组的平方数
     * @param numbers
     * @return
     */
    private static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            result.add(number*number);
        }
        return result;
    }

}
