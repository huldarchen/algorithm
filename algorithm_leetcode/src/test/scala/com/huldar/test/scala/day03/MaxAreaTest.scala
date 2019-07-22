package com.huldar.test.scala.day03

import org.scalatest.FunSuite
import com.huldar.scala.day03.MaxAreaScala

/**
  * 最大盛水量的测试类
  */
class MaxAreaTest extends FunSuite {

  test("testMaxArea") {
    assertResult(49)(new MaxAreaScala().maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))
  }


}
