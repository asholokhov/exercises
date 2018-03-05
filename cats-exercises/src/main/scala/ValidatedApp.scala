import cats.Semigroupal

/**
  * @author Artem Sholokhov
  */
object ValidatedApp extends App {

  import cats.data.Validated
  import cats.instances.list
  import cats.syntax.either._
  import cats.syntax.apply._

  type FormData = Map[String, String]
  type FailFast[A] = Either[List[String], A]
  type FailSlow[A] = Validated[List[String], A]

  case class User(name: String, age: Int)

  def getValue(form: FormData)(name: String): FailFast[String] =
    form.get(name).toRight(List(s"$name field should be specified"))

  def parseInt(field: String)(v: String): FailFast[Int] =
    Either
      .catchOnly[NumberFormatException](v.toInt)
      .leftMap(_ => List(s"$field field should be integer"))

  def nonBlank(name: String)(v: String) =
    Right(v).ensure(List(s"$name shold be non empty"))(_.nonEmpty)

  def nonNegative(name: String)(v: Int) =
    Right(v).ensure(List(s"$name should be non negative"))(_ >= 0)

  //

  def readName(data: FormData): FailFast[String] =
    getValue(data)("name").flatMap(nonBlank("Name"))

  def readAge(data: FormData): FailFast[Int] =
    getValue(data)("age")
      .flatMap(nonBlank("age"))
      .flatMap(parseInt("age"))
      .flatMap(nonNegative("age"))

  // tests
  //

  val data = Map(
    "name" -> "User A",
    "age" -> "15"
  )

  println(getValue(data)("name"))
  println(getValue(data)("test"))

  println(nonBlank("Test field 1")(""))
  println(nonBlank("Test field 2")("Some value"))
  println(nonNegative("Int field 1")(1))
  println(nonNegative("Int field 2")(-1))

  println("---")

  println(readName(data))
  println(readName(Map()))
  println(readName(Map("name" -> "")))

  println(readAge(data))
  println(readAge(Map()))
  println(readAge(Map("age" -> "-10")))

}
