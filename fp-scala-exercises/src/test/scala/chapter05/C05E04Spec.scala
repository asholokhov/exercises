package chapter05

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Artem Sholokhov
  */
class C05E04Spec extends FlatSpec with Matchers {

  "foldRight" should "accumulate sum for Stream elements" in {
    Stream(1, 2, 3, 4, 5).foldRight(0)(_+_) shouldEqual 15
  }

  "exists" should "return true if at least one element in Stream matches predicate" in {
    Stream(1, 2, 3, 4, 5).exists(_ * 2 == 10) shouldEqual true
    Stream(1, 2, 3, 4, 5).exists(_ == 0) shouldEqual false
  }

  "forAll" should "return Stream with elements which match given predicate" in {
    Stream(1, 2, 3, 4, 5).forAll(_ > 0) shouldEqual true
    Stream(1, 2, 3, 4, 5).forAll(_ < 0) shouldEqual false
  }

}
