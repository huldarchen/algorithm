#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: ThreeNumSum.py
@time: 2019/07/22
"""
from typing import List


class Solution:
    @staticmethod
    def three_num_sum(nums: List[int]) -> List[List[int]]:
        """
        三数之和.求三个数的和为0的组合
        :param nums:
        :return:
        """
        if len(nums) < 3: return []
        nums.sort()
        result = []
        i = 0
        while i < len(nums) - 2:
            dic = []
            if nums[i] > 0: break
            if i > 0 and nums[i] == nums[i - 1]:
                i += 1
                continue
            for j in range(i + 1, len(nums)):
                if nums[j] in dic and dic[nums[j]][2] == 0:
                    dic[nums[j]][2] = 1
                    if j > i + 2 and nums[j] == nums[j - 2]:
                        continue
                    result.append(dic[nums[j]][:2] + [nums[j]])
                else:
                    dic[-(nums[i] + nums[j])] = [nums[i], nums[j], 0]
            i += 1
        return result
