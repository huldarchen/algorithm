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


}