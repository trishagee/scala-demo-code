class ImplicitConversion {
  import scala.language.implicitConversions
  {
    implicit val defaultVal: Int = 42

    implicit def stringToInt(s: String)(implicit more: Int): Int = Integer.parseInt(s)
    val i: Int = "123"
  }
}
