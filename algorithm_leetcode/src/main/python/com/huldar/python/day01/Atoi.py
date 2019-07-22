#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: Atoi.py
@time: 2019/06/05
"""
import re


class Solution:
    @staticmethod
    def myAtoi(s: str) -> int:
        return max(min(int(*re.findall('^[\-\+]?\d+', s.strip())), 2 ** 31 - 1), -2 ** 31)

    @staticmethod
    def myAtoi1(s: str) -> int:
        """
        :param s:
        :type str:str
        :rtype: int
        :return:
        """
        str_split = s.split()
        if len(str_split) == 0:
            return 0
        detect_str = str_split[0]

        # 标记起终位置
        star = 0
        end = 0
        # 标记正负号
        flag = 1
        for index in range(len(detect_str)):
            if index == 0 and detect_str[index] in ["-", "+"]:
                flag = 1 if detect_str[index] == "+" else -1
                star += 1
                end += 1
            elif detect_str[index].isdigit():
                end += 1
            else:
                break
        new_num = int(detect_str[star:end]) * flag if star < end else 0
        return min(new_num, 2 ** 31 - 1) if new_num > 0 else max(new_num, -2 ** 31)
