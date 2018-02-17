
object MonadApp extends App {

  trait Monad[F[_]] {
    def pure[A](a: A): F[A]
    def flatMap[A, B](f: F[A])(fn: A => F[B]): F[B]
    def map[A, B](fa: F[A])(fn: A => B): F[B] =
      flatMap(fa)(a => pure(fn(a)))
  }

  import cats.syntax.either._
  println("Test".asRight)

  val r = Either.catchOnly[NumberFormatException] {
    "foo".toInt
  }

  println("Res is", r)

  //
  val z = -1.asRight.ensure("Should be non-negative!")(_ > 0)
  println("z is ", z)

}
