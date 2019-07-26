package com.huldar.test.java.day09;

import com.huldar.java.day09.FourSum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 四数之和
 *
 * @author huldar
 * @date 2019/7/24 10:23
 */
class FourSumTest {
    @Test
    void fourSum() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        int[][] expect = {{-1, 0, 0, 1}, {-2, -1, 1, 2}, {-2, 0, 0, 2}};
        List<List<Integer>> result = FourSum.fourSum(nums, target);
        System.out.println(Arrays.toString(result.toArray()));
    }

}