package com.huldar.test.java.day07;

import com.huldar.java.day07.ThreeSumClosest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 三数最接近测试
 *
 * @author huldar
 * @date 2019/7/23 16:10
 */
class ThreeSumClosestTest {
    @Test
    void threeSumClosest() {
        int[] nums = {-1, 2, 1, -4};
        assertEquals(2, ThreeSumClosest.threeSumClosest(nums, 1));
    }

}