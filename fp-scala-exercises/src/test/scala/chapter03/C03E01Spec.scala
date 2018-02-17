package chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C03E01Spec extends FlatSpec with Matchers {

  "res" should "match correct answer" in {
    Exercise01.res should be (3)
  }

}
