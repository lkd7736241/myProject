package com.sun.数据结构与算法.leetcode;

/**
 * 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * create by qiulisun on 2019/3/10.<br>
 */
public class MaxProfit {
    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfitA = calculateMaxProfitA(prices);
        int maxProfitB = calculateMaxProfitB(prices);
        System.out.println("A方法：" + maxProfitA + ", B方法：" + maxProfitB);
    }

    public static int calculateMaxProfitA(int[] prices) {
        int i = 0;
        int maxProfit = 0;
        int valley = prices[0];
        int peak = prices[0];
        while (i < prices.length - 1){
            while (i < prices.length-1 && prices[i] >= prices[i+1]){
                i++;
            }
            valley = prices[i];
            while (i < prices.length-1 && prices[i] <= prices[i+1]){
                i++;
            }
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    public static int calculateMaxProfitB(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
