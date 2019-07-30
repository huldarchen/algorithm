package com.huldar.test.java.binarySearch;

import com.huldar.java.binarySearch.BinarySearchAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 二分查找算法测试
 *
 * @author huldar
 * @date 2019/7/26 14:55
 */
class BinarySearchAlgorithmTest {

    private BinarySearchAlgorithm binarySearchAlgorithm = new BinarySearchAlgorithm();

    /**
     * NO.4 寻找两个有序数组的中位数
     */
    @Test
    void findMedianSortedArrays() {
        int[] num1 = {1, 2};
        int[] num2 = {2, 3};
        assertEquals(2.0, binarySearchAlgorithm.findMedianSortedArrays(num1, num2));

    }

    /**
     * NO.29 两数相除
     */
    @Test
    void divideTest() {
        int dividend = -2147483648;
        int divisor = 1;
        assertEquals(-2147483648, binarySearchAlgorithm.divide(dividend, divisor));
    }

    /**
     * NO.33 旋转数组查询
     */
    @Test
    void searchRevolveArraysTest() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        assertEquals(-1, binarySearchAlgorithm.searchRevolveArrays(nums, target));
    }
}