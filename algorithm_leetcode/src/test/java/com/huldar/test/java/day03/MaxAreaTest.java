package com.huldar.test.java.day03;

import com.huldar.java.day03.MaxArea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 *
 * @author huldar
 * @date 2019/6/10 16:09
 */
class MaxAreaTest {

    @Test
    void maxArea() {
        assertEquals(49, MaxArea.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(49, MaxArea.maxArea1(new int[]{1,8,6,2,5,4,8,3,7}));
    }

}