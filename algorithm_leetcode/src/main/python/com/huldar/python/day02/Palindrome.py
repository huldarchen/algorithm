#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: Palindrome.py
@time: 2019/06/05
"""


class Solution:
    """
    回文数字
    """

    @staticmethod
    def isPalindrome(x: int):
        if (x < 0):
            return False
        numStr = str(x)
        return numStr == numStr[::-1]
