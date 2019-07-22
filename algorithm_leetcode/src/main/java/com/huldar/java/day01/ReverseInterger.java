package com.huldar.java.day01;

/**
 * LeetCode(7):整数反转
 *
 * @author huldar
 * @date 2019/6/4 11:26
 */
public class ReverseInterger {
    /**
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //取出该个位的数字
            int num = x % 10;
            //数字向左移动一位 末尾去掉
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num < -8)) {
                return 0;
            }
            res = res * 10 + num;
        }
        return res;
    }
}
