package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 字符串最短唯一匹配
 * <p>
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unkown command。
 * <p>
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
 * 6、若匹配失败，打印“unknown command”
 * create by qiulisun on 2020/10/6.<br>
 * @author 51050
 */
public class TheOnlyMatchTheShortest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = "reset";
        String s2 = "reset board";
        String s3 = "board add";
        String s4 = "board delete";
        String s5 = "reboot backplane";
        String s6 = "backplane abort";

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.matches(s1)) {
                System.out.println("reset what");
            } else {
                System.out.println("unknown command");
            }

        }
    }

}
