package chapter03

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  /**
    * EXERCISE 25: Write a function size that counts the number of nodes (leaves
    * and branches) in a tree.
    */
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + size(l) + size(r)
  }

  /**
    * EXERCISE 26: Write a function maximum that returns the maximum element
    * in a Tree[Int]. (Note: in Scala, you can use x.max(y) or x max y to
    * compute the maximum of two integers x and y.)
    */
  def maximum(t: Tree[Int]): Int = t match {
    case Leaf(x) => x
    case Branch(l, r) => math.max(Tree.maximum(l), Tree.maximum(r))
  }

  /**
    * EXERCISE 27: Write a function depth that returns the maximum path length
    * from the root of a tree to any leaf.
    */
  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }

  /**
    * EXERCISE 28: Write a function map, analogous to the method of the same
    * name on List, that modifies each element in a tree with a given function.
    */
  def map[A, B](t: Tree[A])(fn: A => B): Tree[B] = t match {
    case Leaf(x) => Leaf(fn(x))
    case Branch(l, r) => Branch(map(l)(fn), map(r)(fn))
  }

  /**
    * EXERCISE 29: Generalize size, maximum, depth, and map, writing a new
    * function fold that abstracts over their similarities. Reimplement them in terms of
    * this more general function. Can you draw an analogy between this fold function
    * and the left and right folds for List?
    */
  def fold[A, B](t: Tree[A])(f: A => B)(b: (B, B) => B): B = t match {
    case Leaf(x) => f(x)
    case Branch(l, r) => b(fold(l)(f)(b), fold(r)(f)(b))
  }

  def size_f[A](t: Tree[A]): Int =
    fold(t)(_ => 1)((l, r) => 1 + l + r)

  def max_f(t: Tree[Int]): Int =
    fold(t)(x => x)((l, r) => l max r)

  def depth_f[A](t: Tree[A]): Int =
    fold(t)(_ => 1)((l, r) => 1 + (l max r))

  def map_f[A, B](t: Tree[A])(fn: A => B): Tree[B] =
    fold(t)(x => Leaf(fn(x)): Tree[B])((l, r) => Branch(l, r))

}