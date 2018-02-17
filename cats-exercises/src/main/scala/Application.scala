/**
  * @author Artem Sholokhov
  */

final case class Cat(name: String, age: Int, color: String)

object Application extends App {

  import Printable._
  import PrintableInstances._
  import PrintableSyntax._

  implicit val printableCat = new Printable[Cat] {
    override def format(v: Cat): String =
      s"${v.name} is a ${v.age} year-old ${v.color} cat."
  }

  val fluffy = Cat("Fluffy", 4, "brown")
  print(fluffy)
  print(5)
  print("Some string for test")

  val furry = Cat("Furry", 15, "red")
  furry.sprint

  //

  import cats._
  import cats.implicits._
  import cats.syntax._

  implicit val showCat: Show[Cat] = Show.show[Cat](v => s"${v.name} is a ${v.age} year-old ${v.color} cat.")
  val s = fluffy.show
  println("Via Show[Cat]: " + s)

  //

  implicit val eqCat = Eq.instance[Cat] {
    case (c1, c2) => c1 == c2
  }

  println("Furry & Furry = " + (furry === furry))
  println("Furry != Furry = " + (furry =!= furry))
  println("Furry & Fluffy = " + (furry === fluffy))

}
