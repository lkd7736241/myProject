package com.sun.数据结构与算法.assignment;

/**
 * 消费满赠
 * 已知某商场有营销规则，每消费满100赠一张代金券，例如第一次消费350元，则获得3张代金券,
 * 第二次消费70元，获得1张代金券；第三次消费20元，则没有获得代金券;
 * 编写代码实现动态结算，每次输入消费金额，输出本次消费可以获得的代金券的个数
 * create by qiulisun on 2018/12/24.<br>
 */
public class FullGift {

    //顾客累计消费的金额
    public static int consumptionAmount = 0;

    //顾客累计获得的消费券
    public static int isSendOutVoucher = 0;

    public static void main(String[] args){

        int consumptionAmount1 = 350;
        int consumptionAmount2 = 70;
        int consumptionAmount3 = 20;

        int result1 = doFullGift(consumptionAmount1);
        int result2 = doFullGift(consumptionAmount2);
        int result3 = doFullGift(consumptionAmount3);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    /**
     * 满赠计算
     * @param amount 本次消费金额
     * @return 本次消费可以获得的代金券的数量
     */
    public static int doFullGift(int amount) {

        if (amount <= 0) {
        	return 0;
        }

        //累计消费金额变化
        int temp = consumptionAmount + amount;

        //顾客应该获得的消费券数量
        int voucher = temp / 100;

        //本次消费可以获得的代金券的数量
        int result  = voucher - isSendOutVoucher;

        //更新 顾客累计消费的金额 和 顾客累计获得的消费券
        consumptionAmount = temp;
        isSendOutVoucher = voucher;

        return result;
    }
}
