package simianquant.sample

import simianquant.ext.GeneratedImpl

object Sample {

  def main(args: Array[String]): Unit = {
    val x = 1.2
    val y = 2.1

    val res = GeneratedImpl(x, y)
    println(s"x: $x, y: $y")
    println(s"a: ${res.a}, b: ${res.b}, c: ${res.c}")

    println("ho gaya")
  }

}
