package chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C03E02Spec extends FlatSpec with Matchers {

  "tail" should "remove first element from list" in {
    List.tail(List(1, 2, 3, 4)) should be (List(2, 3, 4))
  }

  "tail" should "return empty list for 1-size list" in {
    List.tail(List(1)) should be (Nil)
  }

}
