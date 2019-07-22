#!usr/bin/env python
# -*- coding:utf-8 _*-
"""
@author:huldar
@file: PalindromeTest.py
@time: 2019/06/05
"""
from com.huldar.python.day02.Palindrome import Solution
if __name__ == '__main__':
   flag1 =  Solution.isPalindrome(121)
   flag2 =  Solution.isPalindrome(11)
   flag3 =  Solution.isPalindrome(-1)
   flag4 =  Solution.isPalindrome(122)
   print(flag1,flag2,flag3,flag4)