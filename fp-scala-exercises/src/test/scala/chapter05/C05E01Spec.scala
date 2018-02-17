package chapter05

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Artem Sholokhov
  */
class C05E01Spec extends FlatSpec with Matchers {

  "toList" should "convert Stream into standard List" in {
    Stream(1, 2, 3, 4, 5).toList shouldEqual List(1, 2, 3, 4, 5)
  }

}
