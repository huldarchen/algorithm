package com.huldar.test.java.day04;

import com.huldar.java.day04.RomanToInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 罗马数字转整数测试类
 *
 * @author huldar
 * @date 2019/6/11 15:24
 */
class RomanToIntTest {
    @Test
    void romanToInt() {
        assertEquals(3, RomanToInt.romanToInt("III"));
        assertEquals(4, RomanToInt.romanToInt("IV"));
        assertEquals(58, RomanToInt.romanToInt("LVIII"));
        assertEquals(1994, RomanToInt.romanToInt("MCMXCIV"));
    }

    @Test
    void romanToInt1() {
        assertEquals(3, RomanToInt.romanToInt1("III"));
        assertEquals(4, RomanToInt.romanToInt1("IV"));
        assertEquals(58, RomanToInt.romanToInt1("LVIII"));
        assertEquals(1994, RomanToInt.romanToInt1("MCMXCIV"));
    }

}