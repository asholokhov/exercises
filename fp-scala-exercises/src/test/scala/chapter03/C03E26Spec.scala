package chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C03E26Spec extends FlatSpec with Matchers {

  "maximum" should "return max value in tree 1" in {
    val t: Tree[Int] = Branch(
      Branch(Leaf(17), Leaf(12)),
      Branch(Leaf(42), Branch(Leaf(41), Leaf(99)))
    )
    Tree.maximum(t) should be (99)
  }

  "maximum" should "return max value in tree 2" in {
    val t: Tree[Int] = Branch(Leaf(-1), Leaf(1))
    Tree.maximum(t) should be (1)
  }

}
