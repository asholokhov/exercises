package chapter05

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Artem Sholokhov
  */
class C05E02Spec extends FlatSpec with Matchers {

  "take" should "return Stream with first N elements of given Stream" in {
    Stream(1, 2, 3, 4, 5).take(2).toList shouldEqual List(1, 2)
  }

}
