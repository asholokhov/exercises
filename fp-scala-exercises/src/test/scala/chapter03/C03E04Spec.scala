package chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C03E04Spec extends FlatSpec with Matchers {

  "drop" should "remove first 3 elements from list" in {
    List.drop(List(1, 2, 3, 4), 3) should be (List(4))
  }

  "drop" should "remove all elements from list" in {
    List.drop(List(1, 2, 3, 4), 5) should be (Nil)
  }

  "drop" should "return Nil for empty list" in {
    List.drop(List(1, 2, 3, 4), 5) should be (Nil)
  }

}
