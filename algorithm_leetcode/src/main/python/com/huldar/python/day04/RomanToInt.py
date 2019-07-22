#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: RomanToInt.py
@time: 2019/06/13
"""


class Solution:
    @staticmethod
    def romanToInt(s: str) -> int:
        """
        关键步骤:IV  =  IV - 1 + I 因此 IV 就拆成 I + IV(实际值-I)
        :param s: 罗马数字
        :return: 罗马数字对应的整数
        """
        d = {'I': 1, 'IV': 3, 'V': 5, 'IX': 8, 'X': 10, 'XL': 30, 'L': 50, 'XC': 80, 'C': 100, 'CD': 300, 'D': 500,
             'CM': 800, 'M': 1000}
        return sum(d.get(s[max(i - 1, 0):i + 1], d[n]) for i, n in enumerate(s))

    @staticmethod
    def romanToInt1(s: str) -> int:
        d = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        res = 0
        for i, char in enumerate(s[:-1]):
            if d[char] > d[s[i + 1]]:
                res += d[char]
            else:
                res -= d[char]
        res += d[s[-1]]
        return res
