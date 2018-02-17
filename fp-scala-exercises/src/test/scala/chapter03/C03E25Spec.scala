package chapter03

import org.scalatest.{Matchers, FlatSpec}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C03E25Spec extends FlatSpec with Matchers {

  "size" should "count every node in tree" in {
    val t: Tree[Int] = Branch(
      Branch(Leaf(17), Leaf(12)),
      Branch(Leaf(42), Leaf(1))
    )
    Tree.size(t) should be (7)
  }

}
