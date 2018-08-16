class ImplicitConversion {
  import scala.language.implicitConversions
  {
    implicit def stringToInt(s: String): Int = Integer.parseInt(s)
    val i: Int = "123"
  }
}
