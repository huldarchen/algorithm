package com.huldar.test.java.day06;

import com.huldar.java.day06.ThreeNumSum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 三数之和的测试类
 *
 * @author huldar
 * @date 2019/6/18 16:39
 */
class ThreeNumSumTest {
    @Test
    void threeSum() {
        int[] values ={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = ThreeNumSum.threeSum(values);
        assert lists != null;
        System.out.println(Arrays.toString(lists.toArray()));
    }

}