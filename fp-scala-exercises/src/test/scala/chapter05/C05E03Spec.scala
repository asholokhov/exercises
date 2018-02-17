package chapter05

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Artem Sholokhov
  */
class C05E03Spec extends FlatSpec with Matchers {

  "takeWhile" should "return Stream with elements which match given predicate" in {
    Stream(1, 2, 3, 4, 5).takeWhile(_ < 4).toList shouldEqual List(1, 2, 3)
    Stream(10, 9, 1, 2).takeWhile(_ >= 5).toList shouldEqual List(10, 9)
  }

}
