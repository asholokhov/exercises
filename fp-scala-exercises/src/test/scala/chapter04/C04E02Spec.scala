package chapter04

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 19.04.2017
  */
class C04E02Spec extends FlatSpec with Matchers {

  "variance" should "return correct result for non-empty sequence" in {
    C04Exercises.variance(List(1, 2, 3, 4, 5)) should be (Some(2))
  }

  "variance" should "return None for empty sequence" in {
    C04Exercises.variance(List()) should be (None)
  }

}
