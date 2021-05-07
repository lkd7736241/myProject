package com.sun.设计模式.代理模式.动态代理_李宇春;

/**
 * create by qiulisun on 2020/12/17.<br>
 *
 * @author 51050
 */
public class LiyuchunDemo {
    public static void main(String[] args) throws Exception {
        LiyuchunProxy proxy = new LiyuchunProxy();
        Idol liyuchun = proxy.createProxy();
        String singRes = liyuchun.sing("江南皮革厂");
        System.out.println(singRes);
        String danceRes = liyuchun.dance("钢管舞");
        System.out.println(danceRes);
    }
}
