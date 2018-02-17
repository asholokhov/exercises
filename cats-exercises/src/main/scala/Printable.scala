/**
  * @author Artem Sholokhov
  */
trait Printable[A] {
  self =>
  /**
    * Represents given value as a String in advanced manner.
    */
  def format(v: A): String

  def contramap[B](func: B => A): Printable[B] =
    new Printable[B] {
      override def format(v: B): String =
        self.format(func(v))
    }
}

object Printable {
  def format[A](v: A)(implicit P: Printable[A]) = P.format(v)
  def print[A](v: A)(implicit P: Printable[A]) = println(format(v))
}

object PrintableInstances {
  implicit val printableInt = new Printable[Int] {
    override def format(v: Int): String = s"This is Int <$v>"
  }
  implicit val printableString = new Printable[String] {
    override def format(v: String): String = s"This is String <$v>"
  }
  implicit val printableBool = new Printable[Boolean] {
    override def format(v: Boolean): String =
      if (v) "yes" else "no"
  }
}

object PrintableSyntax {
  implicit class PrintableOps[A](v: A) {
    def sformat(implicit P: Printable[A]) = P.format(v)
    def sprint(implicit P: Printable[A]) = println(P.format(v))
  }
}