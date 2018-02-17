package chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C03E27Spec extends FlatSpec with Matchers {

  "depth" should "return max depth in tree 1" in {
    val t: Tree[Int] = Branch(
      Branch(Leaf(17), Leaf(12)),
      Branch(Leaf(42), Branch(Leaf(41), Leaf(99)))
    )
    Tree.depth(t) should be (4)
  }

  "depth" should "return max depth in tree 2" in {
    val t: Tree[Int] = Branch(Leaf(-1), Branch(Leaf(1), Leaf(2)))
    Tree.depth(t) should be (3)
  }

}
