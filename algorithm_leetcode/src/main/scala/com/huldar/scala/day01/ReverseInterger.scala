package com.huldar.scala.day01

/**
  *
  * 数反转
  *
  * @author huldar
  *
  */
class ReverseInterger {

  def reverse(tag: Int): Int = {
    var res = 0
    var num = 0
    var tag1 = tag
    while (tag1 != 0) {
      num = tag1 % 10
      res = res * 10 + num
      if (res > Int.MaxValue || res < Int.MinValue) {
        return 0
      }
      tag1 = tag1 / 10
    }
    res
  }

  def reverse1(tag: Int): Int = {
    if (tag > -10 && tag < 10)
      tag
    else {
      try {
        val absTag = Math.abs(tag)
        tag / absTag * absTag.toString.reverse.toInt
      } catch {
        case _: Throwable => 0
      }
    }

  }

}
