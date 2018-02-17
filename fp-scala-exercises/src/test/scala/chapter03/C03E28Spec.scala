package chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C03E28Spec extends FlatSpec with Matchers {

  "map" should "multiply each value in the tree in two times" in {
    val t1: Tree[Int] = Branch(Branch(Leaf(17), Leaf(12)), Branch(Leaf(42), Leaf(41)))
    val t2: Tree[Int] = Branch(Branch(Leaf(34), Leaf(24)), Branch(Leaf(84), Leaf(82)))
    Tree.map(t1)(_ * 2) should be (t2)
  }

}
