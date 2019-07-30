package com.huldar.java.binarySearch;

/**
 * LeetCode中二分查找的算法模块
 *
 * @author huldar
 * @date 2019/7/26 14:52
 */
public class BinarySearchAlgorithm {
    /**
     * NO.4 寻找两个有序数组的中位数
     *
     * @param nums1 有序数组
     * @param nums2 有序数组
     * @return 2个有序数组的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        算法思想:
        1.什么是中位数?
            中位数（又称中值，英语：Median），统计学中的专有名词，
            代表一个样本、种群或概率分布中的一个数值，其可将数值集合划分为相等的上下两部分。
        2.思路概览
            也就是说将数组nums1和nums2分别分成两部分
            使得 left[nums1]+left[nums2]=right[nums1]+right[nums2]
            median = (max[left] + min[right])/2
        3.具体思路(从0开始)
           假设nums1的长度是m,nums2的长度是n.使用i对nums1进行切分 总共有m+1中切法;使用j对nums2进行切分总共有n+1中切法
           左半部分:i+j
           右半部分:m-i+n-j
           那么就有以下几种情况
            ①左半部分=右半部分
                j= (m+n)/2-i   median = (max[nums1[i-1],nums2[j-1]] +min[nums1[i],nums2[j]])/2
            ②数组总长度为奇数,且保证左半部分>右半部分 且为1
                j = (m+n+1)/2-i median = max(nums1[i-1] , nums2[j-1])
           以上条件是可以合并的
           对于第一个条件因为在计算中整数/2 奇数和偶数的到的值是一样的
               因此①就j也可以表示为 j = ((m+n+1)/2-i)
               由于 0<=i<=m，为了保证0<=j<=n，我们必须保证m<=n。
           对于第二个条件
            为了保证max[nums1[i-1],nums2[j-1]] <= min[nums1[i],nums2[j]]
            既要保证nums2[j-1]<=nums1[i]和nums1[i-1]<=nums2[j]

            左右移动i或者j使其能满足

         */
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            //二分查找的体现
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            //移动i或者j使其满足条件
            if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                //i需要减少
                iMax = i - 1;
            } else {
                //达到要求 将边界值列出单独考虑
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    //正常情况
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                //如果数组总体是奇数 直接返回左边
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    /**
     * NO.29 两数相除 不使用除法
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 结果
     */
    public int divide(int dividend, int divisor) {

        //符号位 异或 相同则false 不同则true
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        //将int转换成long防止在左移的时候超过int的范围
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);

        long res = 0;
        //二分+位运算
        while (m >= n) {

            long t = n, p = 1;
            while (m >= (t << 1)) {
                p <<= 1;
                t <<= 1;
            }
            res += p;
            m -= t;
        }
        if (res > Integer.MAX_VALUE && sign > 0 || res < Integer.MIN_VALUE && sign < 0) {
            res = Integer.MAX_VALUE;
        }
        return (int) (sign > 0 ? res : -res);
    }

    /**
     * NO.33 搜索旋转排序数组
     * 时间复杂度必须是 O(log n) 级别。
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值在数组中的位置, 不在数组中返回-1
     */
    public int searchRevolveArrays(int[] nums, int target) {
        /*
        旋转排序数组就是部分有序的数组(原数组整体分为两个有序的数组)

         */
        int res = -1;
        //特殊情况处理
        int length = nums.length;
        if (length == 0) {
            return res;
        }
        //
        int left = 0, right = length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left == right && nums[left] == target ? left : -1;
    }
}
