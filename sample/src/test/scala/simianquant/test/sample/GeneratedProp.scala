package simianquant.test.sample

import org.scalactic.anyvals.PosInt
import org.scalacheck.Gen
import org.scalacheck.Prop.{all, forAll, AnyOperators}
import org.scalatest.prop.Checkers
import org.scalatest.PropSpec
import simianquant.ext.GeneratedImpl

final class GeneratedProp extends PropSpec with Checkers {

  implicit override final val generatorDrivenConfig = PropertyCheckConfiguration(
    minSuccessful = 1000, // at least 1000 successful evaluations
    workers = PosInt.from(Runtime.getRuntime().availableProcessors()).get)

  private val cases = for {
    x <- Gen.choose(1.0, 2.0)
    y <- Gen.choose(1.5, 2.5)
  } yield (x, y)

  private val _eps = 1e-15

  property("evaluation test") {
    check(
      forAll(cases) {
        case (x, y) =>
          val expected_a = math.pow(x + y, 2) / x
          val expected_b = math.sin(expected_a)
          val expected_c = math.sin(expected_a) / expected_a

          val actual = GeneratedImpl(x, y)

          all(
            "a evaluated correctly" |: true =? math.abs(expected_a - actual.a) < _eps,
            "b evaluated correctly" |: true =? math.abs(expected_b - actual.b) < _eps,
            "c evaluated correctly" |: true =? math.abs(expected_c - actual.c) < _eps
          )
      }
    )
  }

}
