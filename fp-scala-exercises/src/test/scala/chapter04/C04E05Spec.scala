package chapter04

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 19.04.2017
  */
class C04E05Spec extends FlatSpec with Matchers {

  "sequence" should "return Some for list" in {
    C04Exercises.sequence(List(Some(1), Some(2), Some(3))) should be (Some(List(1, 2, 3)))
  }

  "sequence" should "return None for list with Nones" in {
    C04Exercises.sequence(List(Some(1), None, Some(3), Some(4))) should be (None)
  }

}
