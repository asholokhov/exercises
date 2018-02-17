package chapter04

/**
  * Author: artem.sholokhov,
  * 19.04.2017
  */

/**
  * EXERCISE 7: Implement versions of map, flatMap, orElse, and map2 on
  * Either that operate on the Right value.
  */
trait Either[+E, +A] {

  def map[B](f: A => B): Either[E, B] = this match {
    case Left(e) => Left(e)
    case Right(x) => Right(f(x))
  }

  def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = map(f) match {
    case Left(e) => Left(e)
    case Right(x) => x
  }

  def orElse[EE >: E, B >: A](b: => Either[EE, B]): Either[EE, B] = this match {
    case Left(e) => b
    case Right(x) => this
  }

  def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] =
    this flatMap {
      th =>
        b map {
          bb => f(th, bb)
        }
    }

}

case class Left[+E](value: E) extends Either[E, Nothing]

case class Right[+A](value: A) extends Either[Nothing, A]

object C04Either {

  /**
    * EXERCISE 8: Implement sequence and traverse for Either.
    */
  def sequence[E, A](a: List[Either[E, A]]): Either[E, List[A]] =
    traverse(a)(x => x)

  def traverse[E, A, B](xs: List[A])(f: A => Either[E, B]): Either[E, List[B]] =
    xs match {
      case Nil => Right(Nil)
      case h :: t => f(h) flatMap (rh => traverse(t)(f) map (rh :: _))
    }

}