package chapter03

import scala.annotation.tailrec

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  /**
    * EXERCISE 2: Implement the function tail for "removing" the first element
    * of a List. Notice the function takes constant time. What are different choices you
    * could make in your implementation if the List is Nil? We will return to this
    * question in the next chapter.
    */
  def tail[A](xs: List[A]): List[A] = xs match {
    case Cons(_, t) => t
    case Nil => Nil
  }

  /**
    * EXERCISE 3: Using the same idea, implement the function setHead for
    * replacing the first element of a List with a different value.
    */
  def setHead[A](xs: List[A], v: A): List[A] = xs match {
    case Cons(_, t) => Cons(v, t)
    case Nil => Nil
  }

  /**
    * EXERCISE 4: Generalize tail to the function drop, which removes the first
    * n elements from a list. Notice this function takes time proportional only to the
    * number of elements being dropped—we do not need to make a copy of the entire List.
    */
  def drop[A](xs: List[A], n: Int): List[A] =
    if (n <= 0) xs else drop(tail(xs), n - 1)

  /**
    * EXERCISE 5: Implement dropWhile, which removes elements from the
    * List prefix as long as they match a predicate.
    */
  def dropWhile[A](xs: List[A], f: A => Boolean): List[A] = xs match {
    case Cons(h, t) => if (f(h)) dropWhile(t, f) else xs
    case Nil => Nil
  }

  /**
    * Function that adds all the elements of one list
    * to the end of another.
    */
  def append[A](xs1: List[A], xs2: List[A]): List[A] =
    xs1 match {
      case Nil => xs2
      case Cons(h, t) => Cons(h, append(t, xs2))
    }

  /**
    * EXERCISE 6: Not everything works out so nicely. Implement a function,
    * init, which returns a List consisting of all but the last element of a List. So,
    * given List(1,2,3,4), init will return List(1,2,3).
    */
  def init[A](xs: List[A]): List[A] = xs match {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(h, t) => Cons(h, init(t))
  }

  def foldRight[A, B](xs: List[A], z: B)(f: (A, B) => B): B = xs match {
    case Nil => z
    case Cons(h, t) => f(h, foldRight(t, z)(f))
  }

  def sum2(xs: List[Int]): Int =
    foldRight(xs, 0)(_ + _)

  def product2(xs: List[Double]): Double =
    foldRight(xs, 1.0)(_ * _)

  /**
    * EXERCISE 7: Can product implemented using foldRight immediately
    * halt the recursion and return 0.0 if it encounters a 0.0? Why or why not?
    * Consider how any short-circuiting might work if you call foldRight with a
    * large list. This is a deeper question that we'll return to a few chapters from now.
    *
    * Answer: no, because foldRight doesn't have any mechanism to stop execution at the moment.
    */

  /**
    * Exercise 9
    * Compute the length of a list using foldRight.
    */
  def length[A](l: List[A]): Int =
    foldRight(l, 0)((_, y) => y + 1)

  /**
    * EXERCISE 10: foldRight is not tail-recursive and will StackOverflow
    * for large lists. Convince yourself that this is the case, then write another general
    * list-recursion function, foldLeft that is tail-recursive, using the techniques we
    * discussed in the previous chapter.
    */
  @tailrec
  def foldLeft[A, B](xs: List[A], z: B)(f: (B, A) => B): B = xs match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

  /**
    * EXERCISE 11: Write sum, product, and a function to compute the length of
    * a list using foldLeft.
    */
  def sum3(xs: List[Int]): Int =
    foldLeft(xs, 0)(_ + _)

  def product3(xs: List[Double]): Double =
    foldLeft(xs, 1.0)(_ * _)

  def length3[A](xs: List[A]): Int =
    foldLeft(xs, 0)((ln, _) => ln + 1)

  /**
    * EXERCISE 12: Write a function that returns the reverse of a list (so given
    * List(1,2,3) it returns List(3,2,1)). See if you can write it using a fold.
    */
  def reverse[A](xs: List[A]): List[A] =
    foldLeft(xs, Nil: List[A])((rs, e) => Cons(e, rs))

  /**
    * EXERCISE 13 (hard): Can you write foldLeft in terms of foldRight?
    * How about the other way around?
    */
  def foldLeft2[A, B](xs: List[A], z: B)(f: (B, A) => B): B = ???

  def foldRight2[A, B](xs: List[A], z: B)(f: (A, B) => B): B = ???

  /**
    * EXERCISE 14: Implement append in terms of either foldLeft or foldRight.
    */
  def append2[A](xs1: List[A], xs2: List[A]): List[A] = ???

  /**
    * EXERCISE 15 (hard): Write a function that concatenates a list of lists into a
    * single list. Its runtime should be linear in the total length of all lists. Try to use
    * functions we have already defined.
    */
  def concatListOfLists[A](xs: List[List[A]]): List[A] = ???

  /**
    * EXERCISE 16: Write a function that transforms a list of integers by adding 1 to each
    *  element. (Reminder: this should be a pure function that returns a new List!)
    */
  def add1(l: List[Int]): List[Int] = ???

  /**
    * EXERCISE 17: Write a function that turns each value in a List[Double] into a String.
    * You can use the expression d.toString to convert some d: Double to a String.
    */
  def doubleListToString(l: List[Double]): List[String] = ???

  /**
    * EXERCISE 18: Write a function map that generalizes modifying each element in a list
    * while maintaining the structure of the list.
    */
  def map[A, B](l: List[A])(f: A => B): List[B] = ???

  /**
    * EXERCISE 19: Write a function filter that removes elements from a list unless they
    * satisfy a given predicate. Use it to remove all odd numbers from a
    * List[Int].
    */
  def filter[A](l: List[A])(f: A => Boolean): List[A] = ???

  /**
    * EXERCISE 20: Write a function flatMap that works like map except that the function given
    * will return a list instead of a single result, and that list should be
    * inserted into the final resulting list.
    */
  def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = ???

  /**
    * EXERCISE 21: Can you use flatMap to implement filter?
    */
  def filter2[A](l: List[A])(f: A => Boolean): List[A] = ???

  /**
    * EXERCISE 22: Write a function that accepts two lists and constructs a new list by adding
    * corresponding elements. For example, List(1,2,3) and List(4,5,6) becomes
    * List(5,7,9).
    */
  def addInt(l1: List[Int], l2: List[Int]): List[Int] = ???

  /**
    * EXERCISE 23: Generalize the function you just wrote so that it’s not specific to
    * integers or addition.
    */
  def zip[A](l1: List[A], l2: List[A])(f: (A, A) => A): List[A] = ???

  /**
    * EXERCISE 24 (hard): As an example, implement hasSubsequence for checking whether
    * a List contains another List as a sub sequence. For instance, List(1,2,3,4) would
    * have List(1,2), List(2,3), and List(4) as sub sequences, among others. You
    * may have some difficulty finding a concise purely functional implementation
    * that is also efficient. That’s okay. Implement the function however comes
    * most naturally. We’ll return to this implementation in chapter 5 and
    * hopefully improve on it. Note: any two values, x, and y, can be compared
    * for equality in Scala using the expression x == y.
    */
  def hasSubsequence[A](l: List[A], sub: List[A]): Boolean = ???

}
