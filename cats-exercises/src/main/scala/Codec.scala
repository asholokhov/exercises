object CodecApp extends App {

  trait Codec[A] {
    def encode(v: A): String
    def decode(v: String): A
    def imap[B](dev: A => B, enc: B => A): Codec[B]
  }

  def encode[A](value: A)(implicit c: Codec[A]): String =
    c.encode(value)

  def decode[A](value: String)(implicit c: Codec[A]): A =
    c.decode(value)

  implicit val stringCodec: Codec[String] =
    new Codec[String] {
      override def encode(v: String): String = v
      override def decode(v: String): String = v
      override def imap[B](dev: String => B, enc: B => String): Codec[B] = ???
    }

  implicit val intCodec: Codec[Int] =
    stringCodec.imap(_.toInt, _.toString)
  implicit val booleanCodec: Codec[Boolean] =
    stringCodec.imap(_.toBoolean, _.toString)

}


