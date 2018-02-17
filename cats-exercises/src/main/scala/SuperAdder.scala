/**
  * @author Artem Sholokhov
  */
object SuperAdder extends App {
  import cats._
  import cats.implicits._

  case class Order(totalCost: Double, quantity: Double)
  object Order {
    implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
      override def empty: Order = Order(0, 0)
      override def combine(x: Order, y: Order): Order =
        Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
    }
  }

  def add[A](xs: List[A])(implicit M: Monoid[A]): A =
    xs.foldLeft(M.empty)(M.combine)

  println(add(List(1,2,3)))
  println(add(List(1.0,2.0,3.0)))
  println(add(List("Hey", "Cruel", "World")))
  println(add(List(Some(1),Some(2),None,Some(3))))

  println(add(List(
    Order(1.0, 1.0),
    Order(2.0, 3.0),
    Order(5.0, 10.0),
  )))

}
