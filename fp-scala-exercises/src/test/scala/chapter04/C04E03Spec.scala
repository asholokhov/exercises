package chapter04

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 19.04.2017
  */
class C04E03Spec extends FlatSpec with Matchers {

  "map2" should "combine two Options" in {
    C04Exercises.map2(Some(4), Some(5))(_ + _) should be (Some(9))
  }

  "map2" should "return None when a = None" in {
    C04Exercises.map2(None, Some(5))((x, _) => x) should be (None)
  }

  "map2" should "return None when b = None" in {
    C04Exercises.map2(Some(4), None)((x, _) => x) should be (None)
  }

}
