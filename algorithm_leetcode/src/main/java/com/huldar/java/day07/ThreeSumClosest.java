package com.huldar.java.day07;

import java.util.Arrays;

/**
 * 给定一个包含n个整数的数组nums和一个目标值target.
 * 找出nums中三个整数,使得它们的和与target最接近.
 * 返回这三个数的和.
 *
 * @author huldar
 * @date 2019/7/23 15:50
 */
public class ThreeSumClosest {

    /**
     * 三数之和接近
     *
     * @param nums   给定的n个整数的数组
     * @param target 目标值
     * @return 三个数的之和
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("给定的数组不符合要求,其长度必须大于3.");
        }
        Arrays.sort(nums);
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        //找出最大的值
        int res = nums[0] + nums[1] + nums[len - 1];
        for (int i = 0; i < len - 2; i++) {
            //如果该属于下一个数相同则跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //不管是大是小 始终让sum接近target
                if (sum > target) {
                    // 如果大了，尝试右边界收缩一格，让 target 变小
                    right--;
                } else if (sum < target) {
                    // 如果小了，尝试左边界收缩一格，让 target 变大
                    left++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }
                int absDiff = Math.abs(sum - target);
                if (absDiff < diff) {
                    diff = absDiff;
                    res = sum;
                }
            }

        }
        return res;
    }
}
