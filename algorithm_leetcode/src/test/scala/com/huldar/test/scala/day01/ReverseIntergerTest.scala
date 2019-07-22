package com.huldar.test.scala.day01


import com.huldar.scala.day01.ReverseInterger
import org.scalatest.FunSuite

/**
  *
  * TODO
  *
  * @author huldar
  *         2019/6/4 13:48
  *
  */
class ReverseIntergerTest extends FunSuite {

  test("testReverse") {
    assertResult(321)(new ReverseInterger().reverse(123))
  }

  test("testReverse1") {
    assertResult(0)(new ReverseInterger().reverse1(2147483647))
  }

}
