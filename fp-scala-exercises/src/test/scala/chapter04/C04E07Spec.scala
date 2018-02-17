package chapter04

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 19.04.2017
  */
class C04E07Spec extends FlatSpec with Matchers {

  "map" should "return Either {left}" in {
    val ex = new Exception("C04E07Spec")
    Left(ex).map(e => e) should be (Left(ex))
  }

  it should "return Either {right}" in {
    Right(5).map[Int](_ * 2) should be (Right(10))
  }

  "flatMap" should "return Either {left}" in {
    val ex = new Exception("C04E07Spec")
    Left(ex).flatMap(e => Right(e)) should be (Left(ex))
  }

  it should "return Either {right}" in {
    Right(5).flatMap(x => Right(x)) should be (Right(5))
  }

  "orElse" should "return Right(5)" in {
    Right(5) orElse Right(6) should be (Right(5))
  }

  it should "return Right(6)" in {
    val ex = new Exception("C04E07Spec")
    Left(ex) orElse Right(6) should be (Right(6))
  }

  "map2" should "apply function correctly" in {
    Right(5).map2(Right(3))(_*_) should be (Right(15))
  }

}
