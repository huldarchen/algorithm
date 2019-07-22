package com.huldar.scala.day02

/**
  *
  * LeetCode-8 判断是否是回文
  *
  * @author huldar
  *
  */
class Palindrome {
  def isPalindrome(x: Int): Boolean = {
    val value = Seq(x).view.filter(x => x.toString == x.toString.reverse)
    value.nonEmpty
  }
}
