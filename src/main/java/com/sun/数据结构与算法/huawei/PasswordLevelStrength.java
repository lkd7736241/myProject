package com.sun.数据结构与算法.huawei;

import java.util.Scanner;

/**
 * 密码等级强度
 * <p>
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 * <p>
 * 一、密码长度:
 * <p>
 * 5 分: 小于等于4 个字符
 * <p>
 * 10 分: 5 到7 字符
 * <p>
 * 25 分: 大于等于8 个字符
 * <p>
 * 二、字母:
 * <p>
 * 0 分: 没有字母
 * <p>
 * 10 分: 全都是小（大）写字母
 * <p>
 * 20 分: 大小写混合字母
 * <p>
 * 三、数字:
 * <p>
 * 0 分: 没有数字
 * <p>
 * 10 分: 1 个数字
 * <p>
 * 20 分: 大于1 个数字
 * <p>
 * 四、符号:
 * <p>
 * 0 分: 没有符号
 * <p>
 * 10 分: 1 个符号
 * <p>
 * 25 分: 大于1 个符号
 * <p>
 * 五、奖励:
 * <p>
 * 2 分: 字母和数字
 * <p>
 * 3 分: 字母、数字和符号
 * <p>
 * 5 分: 大小写字母、数字和符号
 * <p>
 * 最后的评分标准:
 * <p>
 * >= 90: 非常安全
 * <p>
 * >= 80: 安全（Secure）
 * <p>
 * >= 70: 非常强
 * <p>
 * >= 60: 强（Strong）
 * <p>
 * >= 50: 一般（Average）
 * <p>
 * >= 25: 弱（Weak）
 * <p>
 * >= 0:  非常弱
 * <p>
 * <p>
 * 对应输出为：
 * <p>
 * VERY_SECURE
 * <p>
 * SECURE,
 * <p>
 * VERY_STRONG,
 * <p>
 * STRONG,
 * <p>
 * AVERAGE,
 * <p>
 * WEAK,
 * <p>
 * VERY_WEAK,
 * <p>
 * <p>
 * 请根据输入的密码字符串，进行安全评定。
 * <p>
 * 注：
 * <p>
 * 字母：a-z, A-Z
 * <p>
 * 数字：-9
 * <p>
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 * <p>
 * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
 * <p>
 * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
 * <p>
 * [\]^_`              (ASCII码：x5B~0x60)
 * <p>
 * {|}~                (ASCII码：x7B~0x7E)
 * <p>
 * create by qiulisun on 2020/11/6.<br>
 * @author 51050
 */
public class PasswordLevelStrength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int pwdLevel = getPwdLevel(line);

            if (pwdLevel >= 90) {
                System.out.println("VERY_SECURE");
            } else if (pwdLevel >= 80 && pwdLevel < 90) {
                System.out.println("SECURE");
            } else if (pwdLevel >= 70 && pwdLevel < 80) {
                System.out.println("VERY_STRONG");
            } else if (pwdLevel >= 60 && pwdLevel < 70) {
                System.out.println("STRONG");
            } else if (pwdLevel >= 50 && pwdLevel < 60) {
                System.out.println("AVERAGE");
            } else if (pwdLevel >= 25 && pwdLevel < 50) {
                System.out.println("WEAK");
            } else if (pwdLevel >= 0 && pwdLevel < 25) {
                System.out.println("VERY_WEAK");
            }
        }
    }

    private static int getPwdLevel(String passWord) {
        int result = 0;
        char[] chars = passWord.toCharArray();
        // 校验字符串长度
        result = checkLength(result, chars);

        boolean upper = false;
        boolean lower = false;
        int numCount = 0;
        int symbolCount = 0;

        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {
                lower = true;
            } else if (aChar >= 'A' && aChar <= 'Z') {
                upper = true;
            } else if (aChar >= '0' && aChar <= '9') {
                numCount++;
            } else if (aChar >= 0x21 && aChar <= 0x2F ||
                    aChar >= 0x3A && aChar <= 0x40 ||
                    aChar >= 0x5B && aChar <= 0x60 ||
                    aChar >= 0x7B && aChar <= 0x7E) {
                symbolCount++;
            }
        }

        if (upper && lower) {
            result += 20;
        } else if (upper ^ lower) {
            result += 10;
        }

        if (numCount == 1) {
            result += 10;
        } else if (numCount > 1) {
            result += 20;
        }

        if (symbolCount == 1) {
            result += 10;
        } else if (symbolCount > 1) {
            result += 25;
        }

        if ((upper ^ lower) && numCount >= 1) {
            result += 2;
        } else if ((upper ^ lower) && numCount >= 1 && symbolCount >= 1) {
            result += 3;
        } else if (upper && lower && numCount >= 1 && symbolCount >= 1) {
            result += 5;
        }

        return result;
    }

    private static int checkLength(int result, char[] chars) {
        int length = chars.length;
        if (length <= 4) {
            result += 5;
        } else if (length <= 7 && length >= 5) {
            result += 10;
        } else if (length >= 8) {
            result += 25;
        }
        return result;
    }
}
