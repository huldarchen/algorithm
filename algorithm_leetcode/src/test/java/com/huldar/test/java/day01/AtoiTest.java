package com.huldar.test.java.day01;

import com.huldar.java.day01.Atoi;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 字符串转换整数测试
 *
 * @author huldar
 * @date 2019/6/5 09:04
 */
class AtoiTest {
    @Test
    void myAtoiTest() {
        assertEquals(42, Atoi.myAtoi("42"));
        assertEquals(-42, Atoi.myAtoi("   -42"));
        assertEquals(4193, Atoi.myAtoi("4193 with words"));
        assertEquals(4193, Atoi.myAtoi("4193 with words"));
        assertEquals(0, Atoi.myAtoi("words and 987"));
        assertEquals(-2147483648, Atoi.myAtoi("-91283472332"));
    }

    @Test
    void myAtoi1Test() {
        assertEquals(42, Atoi.myAtoi1("42"));
        assertEquals(-42, Atoi.myAtoi1("   -42"));
        assertEquals(4193, Atoi.myAtoi1("4193 with words"));
        assertEquals(4193, Atoi.myAtoi1("4193 with words"));
        assertEquals(0, Atoi.myAtoi1("words and 987"));
        assertEquals(-2147483648, Atoi.myAtoi1("-91283472332"));
    }

    @Test
    void test1() {
        assertEquals(2, '2' - '0');
    }

    @Test
    void testBig() {
        String last1DayCount = "12122211";
        String last2DayCount = "120221";

        BigDecimal last1Big = new BigDecimal(Long.parseLong(last1DayCount));
        BigDecimal last2Big = new BigDecimal(Long.parseLong(last2DayCount));

        BigDecimal increased = last1Big.subtract(last2Big);

        BigDecimal countRate = increased.divide(last2Big,2,BigDecimal.ROUND_HALF_UP);

        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        System.out.println(decimalFormat.format(last1Big));
        System.out.println(percentInstance.format(countRate.doubleValue()));


    }
}