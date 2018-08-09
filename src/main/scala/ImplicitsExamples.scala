object ImplicitParameters {
  def accept[T](s: String)(implicit i: T): Unit = ()
  implicit val value: Int = 1
  // Implicit argument
  accept[Int]("value")
  // Missing implicit argument
  accept[Double]("value")
  // Explicit argument
  accept[Int]("value")(100)
}
object ImplicitConversions {
  import scala.language.implicitConversions
  implicit def stringToInt(s: String): Int = 123
  val i: Int = "123"
}
object StandardLibrary {
  Seq(1, 2, 3).sorted
  Seq(1, 2, 3).map(_ + 1)
  "abc".map(_.toInt)
  "abc".map(_.toUpper)
}
object Chaining {
  class A; class B; class C; class D
  implicit def aFromB(implicit b: B): A = new A
  implicit def bFromC(implicit c: C): B = new B
  implicit val someC: C = new C
  implicit val someD: D = new D
  def materializeB(implicit a: A, d: D): B = new B
  materializeB
  implicit def cToB(c: C)(implicit a: A): B = new B
  val someB: B = new C
}