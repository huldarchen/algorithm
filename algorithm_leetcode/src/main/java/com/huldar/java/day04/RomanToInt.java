package com.huldar.java.day04;

import java.util.HashMap;

/**
 * 罗马数转化成整数
 *
 * @author huldar
 * @date 2019/6/11 15:02
 */
public class RomanToInt {
    public static int romanToInt(String roman) {
        HashMap<String, Integer> romanInt = new HashMap<>();
        romanInt.put("M", 1000);
        romanInt.put("CM", 900);
        romanInt.put("D", 500);
        romanInt.put("CD", 400);
        romanInt.put("C", 100);
        romanInt.put("XC", 90);
        romanInt.put("L", 50);
        romanInt.put("XL", 40);
        romanInt.put("X", 10);
        romanInt.put("IX", 9);
        romanInt.put("V", 5);
        romanInt.put("IV", 4);
        romanInt.put("I", 1);
        int res = 0;
        for (int i = 0; i < roman.length(); i++) {
            String one = roman.substring(i, i + 1);
            String two = null;
            if (i + 2 <= roman.length()) {
                two = roman.substring(i, i + 2);
            }
            if (two != null && romanInt.get(two) != null) {
                res += romanInt.get(two);
                i += 1;
            } else {
                res += romanInt.get(one);
            }
        }
        return res;
    }

    public static int romanToInt1(String roman) {
        String[] a = new String[]{"CM", "CD", "XC", "XL", "IX", "IV", "M", "D", "C", "L", "X", "V", "I"};
        int[] b = new int[]{900, 400, 90, 40, 9, 4, 1000, 500, 100, 50, 10, 5, 1};
        int result = 0;
        while (roman.length() >= 1) {
            for (int i = 0; i < a.length; i++) {
                if (roman.startsWith(a[i])) {
                    result += b[i];
                    roman = roman.substring(a[i].length());
                    break;
                }
            }
        }
        return result;
    }
}
