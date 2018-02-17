package chapter03

/**
  * Author: artem.sholokhov,
  * 14.04.2017
  */

object Exercise01 {

  /**
    * EXERCISE 01: Choose the right answer
    */
  def res: Int = List(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + List.sum(t)
    case _ => 101
  }

}
