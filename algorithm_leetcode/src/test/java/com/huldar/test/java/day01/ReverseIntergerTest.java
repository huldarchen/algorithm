package com.huldar.test.java.day01;

import com.huldar.java.day01.ReverseInterger;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 * 整数反转测试类
 *
 * @author huldar
 * @date 2019/6/4 11:30
 */
public class ReverseIntergerTest {
    @Test
    void testReverse() {
        int a = -112230;
        int testA = ReverseInterger.reverse(a);
        assertEquals(-32211, testA);

        int b = 120;
        assertEquals(21, ReverseInterger.reverse(b));

        int c = 2147483647;
        assertEquals(0, ReverseInterger.reverse(c));

    }
}
