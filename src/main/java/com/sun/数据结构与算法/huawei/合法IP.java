package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * create by qiulisun on 2021/2/23.<br>
 *
 * @author 51050
 */
public class 合法IP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.next();
            boolean result = checkVaild(ip);
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean checkVaild(String ip) {
        boolean result = true;
        String[] ipSplit = ip.split("\\.");
        for (String str : ipSplit) {
            Integer integer = Integer.valueOf(str);
            if (integer < 0 || integer > 255) {
                result = false;
            }
        }
        return result;
    }
}
