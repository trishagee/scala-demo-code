object ImplicitParams {

  def greet(name: String)(implicit age: Int): Unit =
    println(s"Hi $name, $age!")

  implicit val defaultAge: Int = 43

  greet("Jane")

  greet("Jane")(20)
}
