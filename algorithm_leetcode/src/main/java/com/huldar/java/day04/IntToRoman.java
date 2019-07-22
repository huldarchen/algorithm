package com.huldar.java.day04;

/**
 * 整数转罗马数字
 * 特殊情况有六种
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 算法思想是:使用hash表结构
 * <p>
 * 步骤:
 * 1.定义对应的数组 罗马字符串与数字要一一对应
 * 2.计算数字的倍数
 * 3.根据数字的对应倍数增加几个对应Roman字符
 * 4.减去已经计算的数字 重复循环
 *
 * @author huldar
 * @date 2019/6/11 10:38
 */
public class IntToRoman {
    public static String int2Roman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder("");
        if (num <= 0) {
            return "";
        }
        for (int i = 0; i < 13; i++) {
            int times = num / values[i];
            if (times == 0) {
                continue;
            }
            for (int j = 0; j < times; j++) {
                res.append(romans[i]);
            }
            num = num - (times * values[i]);
            if (num == 0) {
                break;
            }
        }
        return res.toString();
    }
}
