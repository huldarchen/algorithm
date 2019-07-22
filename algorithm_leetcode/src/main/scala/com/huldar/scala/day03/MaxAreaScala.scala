package com.huldar.scala.day03

/**
  *
  * TODO
  *
  * @author huldar
  *
  */
class MaxAreaScala {
  def maxArea(heigth: Array[Int]): Int = {
    if (heigth.length < 2) {
      return 0
    }
    var res = 0
    var i = 0
    var j = heigth.length - 1
    while (i < j) {
      val x = j - i
      val y = math.min(heigth(i), heigth(j))
      val newRes = x * y
      if (newRes > res) {
        res = newRes
      }
      if (heigth(i) < heigth(j)) {
        i += 1
      } else {
        j -= 1
      }
    }
    res
  }

}
