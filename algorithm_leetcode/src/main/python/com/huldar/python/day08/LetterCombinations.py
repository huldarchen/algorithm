#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: LetterCombinations.py
@time: 2019/07/23
"""


class Solution:
    @staticmethod
    def letter_combinations(digits):
        """
        电话号码组合-回溯算法
        :param digits: 由2-9的数字组成
        :return: 数字对应的字符的组合
        """
        mapping = {'2': ['a', 'b', 'c'],
                   '3': ['d', 'e', 'f'],
                   '4': ['g', 'h', 'i'],
                   '5': ['j', 'k', 'l'],
                   '6': ['m', 'n', 'o'],
                   '7': ['p', 'q', 'r', 's'],
                   '8': ['t', 'u', 'v'],
                   '9': ['w', 'x', 'y', 'z']}
        out = []

        def backtrack(combination, next_digits):
            """
            回溯算法
            """
            if len(next_digits) == 0:
                out.append(combination)
            else:
                for letter in mapping[next_digits[0]]:
                    backtrack(combination + letter, next_digits[1:])

        if digits:
            backtrack('', digits)

    @staticmethod
    def letter(digits):
        """
        巧妙的解法
        :param digits:
        :return:
        """
        if not digits:
            return []
        l1 = [""]
        h = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
        for char in digits:
            l1 = [each + i for each in l1 for i in h[char]]
        return l1
