package chapter04

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C04E01Spec extends FlatSpec with Matchers {

  "map" should "multiply value by 2" in {
    Some(5) map (_ * 2) should be (Some(10))
  }

  "getOrElse" should "return actual value if exists" in {
    Some(5) getOrElse Some(8) should be (5)
  }

  it should "return second value if original value not exists" in {
    None getOrElse Some(8) should be (Some(8))
  }

  "flatMap" should "multiply value by 2" in {
    Some(5) flatMap (x => Some(x * 2)) should be (Some(10))
  }

  it should "return None" in {
    None.flatMap(x => x) should be (None)
  }

  "orElse" should "return first Option" in {
    Some(1) orElse Some(2) should be (Some(1))
  }

  it should "return second Option" in {
    None orElse Some(2) should be (Some(2))
  }

  "filter" should "keep value if it is mod by 2" in {
    Some(4).filter(_ % 2 == 0) should be (Some(4))
  }

  it should "skip value if it is mod by 2" in {
    Some(4).filter(_ % 2 != 0) should be (None)
  }

  it should "stay None" in {
    None.filter(_ => true) should be (None)
    None.filter(_ => false) should be (None)
  }

  "mean" should "return mean of given sequence" in {
    C04Exercises.mean(List(1, 2, 3, 4, 5)) should be (Some(3))
  }

  "mean" should "return None for empty sequence" in {
    C04Exercises.mean(List()) should be (None)
  }

}
