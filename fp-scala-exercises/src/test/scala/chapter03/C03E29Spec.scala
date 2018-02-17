package chapter03

import org.scalatest.{FlatSpec, Matchers}

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */
class C03E29Spec extends FlatSpec with Matchers {

  "size_f" should "count every node in tree" in {
    val t: Tree[Int] = Branch(
      Branch(Leaf(17), Leaf(12)),
      Branch(Leaf(42), Leaf(1))
    )
    Tree.size_f(t) should be (7)
  }

  "max_f" should "return max value in tree 1" in {
    val t: Tree[Int] = Branch(
      Branch(Leaf(17), Leaf(12)),
      Branch(Leaf(42), Branch(Leaf(41), Leaf(99)))
    )
    Tree.max_f(t) should be (99)
  }

  "depth_f" should "return max depth in tree 1" in {
    val t: Tree[Int] = Branch(
      Branch(Leaf(17), Leaf(12)),
      Branch(Leaf(42), Branch(Leaf(41), Leaf(99)))
    )
    Tree.depth_f(t) should be (4)
  }

  "map_f" should "multiply each value in the tree in two times" in {
    val t1: Tree[Int] = Branch(Branch(Leaf(17), Leaf(12)), Branch(Leaf(42), Leaf(41)))
    val t2: Tree[Int] = Branch(Branch(Leaf(34), Leaf(24)), Branch(Leaf(84), Leaf(82)))
    Tree.map_f(t1)(_ * 2) should be (t2)
  }

}
