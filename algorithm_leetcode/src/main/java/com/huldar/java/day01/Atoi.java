package com.huldar.java.day01;

/**
 * 字符串转整形
 * <p>
 * 要求:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 *
 * @author huldar
 * @date 2019/6/4 14:21
 */
public class Atoi {
    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        String newStr = str.trim();
        StringBuilder resultStr = new StringBuilder("");
        if (!newStr.isEmpty()) {
            char firstChar = newStr.charAt(0);
            if (firstChar >= '0' && firstChar <= '9' || firstChar == '-' || firstChar == '+') {
                resultStr.append(firstChar);
                for (int i = 1; i < newStr.length(); i++) {
                    char currentChar = newStr.charAt(i);
                    if (currentChar >= '0' && currentChar <= '9') {
                        resultStr.append(currentChar);
                    } else {
                        break;
                    }
                }
            }
        }
        String result = resultStr.toString();
        if (result.isEmpty() || "-".equals(result) || "+".equals(result)) {
            return 0;
        }
        int num = 0;
        try {
            num = Integer.parseInt(result);
        } catch (NumberFormatException e) {
            if (result.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        return num;
    }

    public static int myAtoi1(String str) {
        String trimdStr = str.trim();
        if (trimdStr.length() == 0) {
            return 0;
        }
        char[] charArray = trimdStr.toCharArray();
        long ret = 0;
        boolean isPositive = true;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '-' && i == 0) {
                isPositive = false;
                continue;
            } else if (c == '+' && i == 0) {
                continue;
            } else if (c >= '0' && c <= '9') {
                if (isPositive) {
                    ret = ret * 10 + (c - '0');
                } else {
                    ret = ret * 10 - (c - '0');
                }
                if ((ret < Integer.MIN_VALUE) || (ret > Integer.MAX_VALUE)) {
                    break;
                }
            } else {
                break;
            }
        }
        if (ret >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (ret <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) ret;
    }
}
