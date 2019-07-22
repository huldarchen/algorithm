package com.huldar.java.day03;

/**
 * LeetCode-11  盛水最多的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * @author huldar
 * @date 2019/6/10 16:05
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        int minIndexNum = 2;
        if (height == null || height.length < minIndexNum) {
            return 0;
        }
        int result = 0;
        int i = 0, j = height.length - 1;
        while (j > i) {
            result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    public static int maxArea1(int[] height) {
        int minIndexNum = 2;
        if (height == null || height.length < minIndexNum) {
            return 0;
        }
        int result = 0;
        int i = 0, j = height.length - 1;
        while (j > i) {
            int he = Math.min(height[i], height[j]);
            int le = j - i;
            int newAre = le * he;
            if (result < newAre) {
                result = newAre;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

}
