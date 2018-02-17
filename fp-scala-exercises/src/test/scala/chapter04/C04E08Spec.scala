package chapter04

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 19.04.2017
  */
class C04E08Spec extends FlatSpec with Matchers {

  "traverse" should "return Right for list" in {
    C04Either.traverse[String, Int, Int](
      List(1, 2, 3, 4)
    )(x => Right(x)) should be (Right(List(1, 2, 3, 4)))
  }

  "traverse" should "return Left for list" in {
    C04Either.traverse[String, Int, Int](
      List(1, 2, 3, 4)
    )(x => if (x % 2 == 0) Right(x) else Left("Error")) should be (Left("Error"))
  }

  "sequence" should "return Right for list" in {
    C04Either.sequence[String, Int](
      List(Right(1), Right(2), Right(3))
    ) should be (Right(List(1, 2, 3)))
  }

  "sequence" should "return Left for list" in {
    C04Either.sequence[String, Int](
      List(Right(1), Right(2), Left("No value"))
    ) should be (Left("No value"))
  }

}
