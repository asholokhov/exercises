/**
  * @author Artem Sholokhov
  */
object TreeFunctor extends App {

  import cats._
  import cats.implicits._
  import cats.syntax._

  sealed trait Tree[+A]
  final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
  final case class Leaf[A](value: A) extends Tree[A]

  object Tree {
    implicit val treeFunctor = new Functor[Tree] {
      override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
        case Branch(left, right) => Branch(map(left)(f), map(right)(f))
        case Leaf(v) => Leaf(f(v))
      }
    }
    def branch[A](left: Tree[A], right: Tree[A]): Tree[A] =
      Branch(left, right)
    def leaf[A](v: A): Tree[A] = Leaf(v)
  }

  //

  val tree = Tree.branch(
    Tree.branch(
      Tree.leaf(1),
      Tree.leaf(2)
    ),
    Tree.branch(
      Tree.leaf(3),
      Tree.leaf(4)
    )
  )

  println(tree.map(_ * 2))

}
