package chapter04

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */

/**
  * EXERCISE 1: implement all of the above functions on Option.
  */
sealed trait Option[+A] {

  def map[B](f: A => B): Option[B] = this match {
    case Some(x) => Some(f(x))
    case None => None
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case Some(x) => x
    case None => default
  }

  def flatMap[B](f: A => Option[B]): Option[B] =
    map(f) getOrElse None

  def orElse[B >: A](ob: => Option[B]): Option[B] =
    map(Some(_)) getOrElse ob

  def filter(f: A => Boolean): Option[A] =
    if (map(f) getOrElse false) this
    else None

}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]

object C04Exercises {

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)

  /**
    * EXERCISE 2: Implement the variance function (if the mean is m, variance
    * is the mean of math.pow(x - m, 2), see definition) in terms of mean and
    * flatMap
    */
  def variance(xs: Seq[Double]): Option[Double] = mean(xs) flatMap {
    m => mean(xs.map(x => math.pow(x - m, 2)))
  }

  /**
    * EXERCISE 3: Write a generic function map2, that combines two Option
    * values using a binary function. If either Option value is None,
    * then the return value is too.
    */
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    (a, b) match {
      case (Some(ra), Some(rb)) => Some(f(ra, rb))
      case _ => None
    }

  /**
    * EXERCISE 4: Re-implement bothMatch above in terms of this new function,
    * to the extent possible.
    *
    * Skip this ex.
    */
  def bothMatch_2(pat1: String, pat2: String, s: String): Option[Boolean] = ???

  /**
    * EXERCISE 5: Write a function sequence, that combines a list of Options
    * into one option containing a list of all the Some values in the original list. If the
    * original list contains None even once, the result of the function should be None,
    * otherwise the result should be Some with a list of all the values.
    */
  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    def loop(xs: List[Option[A]], acc: List[A]): Option[List[A]] = xs match {
      case Nil => Some(acc)
      case Some(h) :: t => loop(t, acc :+ h)
      case None :: _ => None
    }

    loop(a, List())
  }

  /**
    * EXERCISE 6: Implement function traverse. It is straightforward to do using map
    * and sequence, but try for a more efficient implementation that only looks at the
    * list once. In fact, implement sequence in terms of traverse.
    */
  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
    case Nil => Some(Nil)
    case h :: t => f(h) flatMap {
      e => traverse(t)(f) map (e :: _)
    }
  }

  def sequence2[A](a: List[Option[A]]): Option[List[A]] =
    traverse(a)(x => x)

}