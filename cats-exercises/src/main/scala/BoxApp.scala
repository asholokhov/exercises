object BoxApp extends App {

  import PrintableInstances._

  final case class Box[A](value: A)
  object Box {
    implicit def boxPrintable[A](implicit p: Printable[A]) =
      p.contramap[Box[A]]((x: Box[A]) => x.value)
  }

  import PrintableSyntax._

  Box(true).sprint
  Box("string inside").sprint
  Box(132).sprint

}
