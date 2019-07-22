package com.huldar.test.scala.day02

import com.huldar.scala.day02.Palindrome
import org.scalatest.FunSuite

/**
  *
  * TODO
  *
  * @author huldar
  * @date 2019/6/10 15:54
  *
  */
class PalindromeTest extends FunSuite {

  test("testIsPalindrome") {
    assertResult(true)(new Palindrome().isPalindrome(121))
    assertResult(false)(new Palindrome().isPalindrome(-1))
    assertResult(false)(new Palindrome().isPalindrome(12))
  }

}
