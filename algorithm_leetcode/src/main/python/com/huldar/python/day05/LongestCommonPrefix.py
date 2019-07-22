#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: LongestCommonPrefix.py
@time: 2019/06/17
"""
from typing import List


class Solution:
    @staticmethod
    def longest_common_prefix(strs: List[str]) -> str:
        """
        最长公共前缀
        使用
        :type strs: List[]
        :return:
        """
        i = zip(*strs)
        for c in i:
            print(c)
        r = [len(set(c)) == 1 for c in zip(*strs)] + [0]
        print(r)
        d = [True, True, False, False, 0]
        print(d.index(0))
        return strs[0][:r.index(0)] if strs else ''

    @staticmethod
    def longest_common_prefix1(strs: List[str]) -> str:
        """
        :type strs: List[str]
        :return: str
        """
        res = ""
        for tmp in zip(*strs):
            tmp_set = set(tmp)
            if len(tmp_set) == 1:
                res += tmp[0]
            else:
                break
        return res


if __name__ == '__main__':
    print(Solution.longest_common_prefix(["flower", "flow", "flight"]))
