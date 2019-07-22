package com.huldar.test.java.day04;

import com.huldar.java.day04.IntToRoman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 整数转罗马数字的验证
 *
 * @author huldar
 * @date 2019/6/11 10:40
 */
class IntToRomanTest {
    @Test
    void int2Roman() {
        assertEquals("IV", IntToRoman.int2Roman(4));
        assertEquals("LVIII", IntToRoman.int2Roman(58));
        assertEquals("IX", IntToRoman.int2Roman(9));
    }

}