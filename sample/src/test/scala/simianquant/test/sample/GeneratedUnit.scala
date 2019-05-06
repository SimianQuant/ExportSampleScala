package simianquant.test.sample

import org.scalatest.FlatSpec
import simianquant.ext.GeneratedImpl

final class GeneratedUnit extends FlatSpec {

  private val _eps = 1e-14

  it should "pass evaluation tests" in {
    val x = 1.2
    val y = 2.1

    val expected_a = math.pow(x + y, 2) / x
    val expected_b = math.sin(expected_a)
    val expected_c = math.sin(expected_a) / expected_a

    val actual = GeneratedImpl(x, y)

    assert(math.abs(actual.a - expected_a) < _eps)
    assert(math.abs(actual.b - expected_b) < _eps)
    assert(math.abs(actual.c - expected_c) < _eps)
  }

}