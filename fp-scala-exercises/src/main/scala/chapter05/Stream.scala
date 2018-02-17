package chapter05

/**
  * @author Artem Sholokhov
  */
trait Stream[+A] {

  import Stream._

  /**
    * EXERCISE 1: Write a function to convert a Stream to a List, which will force
    * its evaluation and let us look at it in the REPL. You can convert to the regular
    * List type in the standard library.
    */
  def toList: List[A] = this match {
    case Cons(h, t) => h() :: t().toList
    case _ => List()
  }

  /**
    * EXERCISE 2: Write a function take for returning the first n elements of a Stream.
    */
  def take(n: Int): Stream[A] = this match {
    case Cons(h, t) if n > 1  => cons(h(), t().take(n - 1))
    case Cons(h, _) if n == 1 => cons(h(), Empty)
    case _                    => Empty
  }

  /**
    * EXERCISE 3: Write the function takeWhile for returning all starting elements of a Stream
    * that match the given predicate.
    */
  def takeWhile(p: A => Boolean): Stream[A] = this match {
    case Cons(h, t) if p(h()) => cons(h(), t().takeWhile(p))
    case _                    => Empty
  }

  /**
    * EXERCISE 4: Implement forAll, which checks that all elements in the Stream match a given
    * predicate. Your implementation should terminate the traversal as soon as it encounters a
    * non-matching value.
    */
  def forAll(p: A => Boolean): Boolean =
    foldRight(true)((a, b) => p(a) && b)

  def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
    case Cons(h, t) => f(h(), t().foldRight(z)(f))
    case Empty => z
  }

  def exists(p: A => Boolean): Boolean =
    foldRight(false)((a, b) => p(a) || b)

}

case object Empty extends Stream[Nothing]

case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def apply[A](as: A*): Stream[A] =
    if (as.isEmpty) empty
    else cons(as.head, apply(as.tail: _*))
}