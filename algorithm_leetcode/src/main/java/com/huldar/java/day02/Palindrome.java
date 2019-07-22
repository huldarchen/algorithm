package com.huldar.java.day02;

/**
 * leetcode-8 判断是否是回文
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * @author huldar
 * @date 2019/6/5 10:20
 */
public class Palindrome {
    public static boolean isPalindrome(int x) {
        char minus = '-';
        //将整数转换成字符串
        String intStr = String.valueOf(x);
        if (intStr.charAt(0) == minus) {
            return false;
        }
        for (int i = 0; i < intStr.length() / 2; i++) {
            if (intStr.charAt(i) != intStr.charAt(intStr.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
