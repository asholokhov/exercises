package chapter04

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 19.04.2017
  */
class C04E06Spec extends FlatSpec with Matchers {

  "traverse" should "return Some for list" in {
    C04Exercises.traverse[Option[Int], Int](List(Some(1), Some(2), Some(3)))(x => x) should be (Some(List(1, 2, 3)))
  }

  "traverse" should "return None for list with Nones" in {
    C04Exercises.traverse[Option[Int], Int](List(Some(1), None, Some(3)))(x => x) should be (None)
  }

  "sequence2" should "return Some for list" in {
    C04Exercises.sequence2(List(Some(1), Some(2), Some(3))) should be (Some(List(1, 2, 3)))
  }

  "sequence2" should "return None for list with Nones" in {
    C04Exercises.sequence2(List(Some(1), None, Some(3))) should be (None)
  }

}
