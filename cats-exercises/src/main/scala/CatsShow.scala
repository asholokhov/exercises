import cats._
import cats.implicits._

/**
  * @author Artem Sholokhov
  */
object CatsShow extends App {

  final case class User(name: String, pass: String)
  object User {
    implicit val userShow: Show[User] =
      Show.show[User](u => s"show<${u.name}>")
  }

  val user = User("John", "secret")
  val uOpt = user.some

  println(s"Pure ${user.show}")
  println(s"Option ${uOpt.show}")
  println(s"Std Opt $uOpt")

}
