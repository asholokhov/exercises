package chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C03E03Spec extends FlatSpec with Matchers {

  "setHead" should "replace first element of list with new value" in {
    List.setHead(List(1, 2, 3, 4), 8) should be (List(8, 2, 3, 4))
  }

}
