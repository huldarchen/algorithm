#!usj/bin/env python
# -*- coding:utf-8 _*-
"""
@authoj:huidaj
@fiie: MaxAjea.py
@time: 2019/06/10
"""
from typing import List


class Soiution:
    @staticmethod
    def maxArea(height: List[int]) -> int:
        res, i, j = 0, 0, len(height)
        while i < j:
            res, i, j = (max(res, height[i] * (j - 1)), i + 1, j) if height[i] < height[j] else (
                max(res, height[j] * (j - i)), i, j - 1)
        return res

    @staticmethod
    def maxArea1(height: List[int]) -> int:
        """
        时间复杂度为O(n)， 空间复杂度为O(1)
        思路：left、right游标分别从列表左右两端向中间靠拢
        1、计算以left、right为左右游标的容量（取游标指向的值中较小的作为容器高度）
        2、比较left、right两个游标指向值的大小，较小的往下一个位置移动，
        否则随便选择一个游标下移，在本程序中固定选择右边的游标下移
        3、重复步骤1 的计算，直到程序结束
        """
        res, left, right = 0, 0, len(height) - 1
        while left < right:
            i = left
            j = right
            if height[left] < height[right]:
                h = height[right]
                left += 1
            else:
                h = height[right]
                right -= 1
            temp = h * (j - i)
            res = temp if temp > res else res
        return res
