#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: ReverseInterger.py
@time: 2019/06/04
"""


class Solution:
    @staticmethod
    def reverse(x: int) -> int:
        flag = 1 if x >= 0 else -1
        new_x = 0
        abs_x = abs(x)
        while abs_x:
            new_x = new_x * 10 + abs_x % 10
            abs_x //= 10
        new_x = flag * new_x
        return new_x if new_x < 2147483648 and new_x >= -2147483648 else 0

    @staticmethod
    def reverse1(x: int) -> int:
        """
        字符串反转
        :param x:
        :return:
        """
        if -10 < x < 10:
            return x
        else:
            str_x = str(x)
            if str_x[0] != '-':
                str_x = str_x[::-1]
                x = int(str_x)
            else:
                str_x = str_x[1:][::-1]
                x = int(str_x)
                x = -x
        return x if x > -2147483648 and x < 2147483648 else 0
