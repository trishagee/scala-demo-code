class Implicits {
  import scala.language.implicitConversions
  def greet(name: String)(implicit age: Int): Unit =
    println(s"Hi $name, $age!")
  implicit val defaultAge: Int = 18
  // View / Parameter Info (Ctrl + P) now shows all parameter lists, including implicit ones
  greet("Jane")
  def assumedAge(implicit age: Int): Int = age
  // You can now invoke Parameter Info even without an argument list
  assumedAge
  // View / Show Implicit Hints reveals actual arguments to implicit parameters
  // You may also invoke Parameter Info to see both the parameters and the arguments at once
  greet("Jane")
  // Ctrl + Alt + Shift + "+" enables the mode
  // Ctrl + Alt + Shift + "-" disables the mode
  // Find Action (Ctrl + A) can show / update "Show Implicit Hints" state
  // You may right-click on the hint and see / update "Show Implicit Hints" state
  // You can see a tooltip with details by pressing Ctrl / Cmd and holding mouse pointer over a hint
  greet("Jane")
  // You can navigate to the argument definition either by Ctrl / Cmd + Mouse 1, or by Mouse 3
  greet("Jane")
  // Explicit arguments to implicit parameters are shown with ".explicitly" prefix
  greet("Jane")(20)
  // Missing implicit arguments are displayed as errors
  def acceptBoolean(implicit b: Boolean): Unit = ()
//  acceptBoolean
    // You can see ambiguous implicit arguments
    // Click on "..." to expand the folding
    // Press Esc to close all previously expanded foldings
  {
    implicit val maybeTrue: Boolean = true
    implicit val maybeFalse: Boolean = true
    acceptBoolean
  }
    // Implicit conversions are also revealed
    // You may right-click on the conversion and choose "Make explicit"
  {
    implicit def stringToInt(s: String): Int = Integer.parseInt(s)
    val i: Int = "123"
  }
    // Implicit conversions include implicit arguments
  {
    implicit def stringToIntWithMore(s: String)(implicit more: Int): Int = Integer.parseInt(s) + more
    val i: Int = "123"
  }
  // View / Expand Implicit Hints unfolds all hints and keep them unfolded
  // You may edit the code while keeping the hints fully expanded
  // Error details are expanded as well
  // Ctrl + Alt + Shift + "+" enables the mode
  // Ctrl + Alt + Shift + "-" disables the mode
  // Find Action (Ctrl + A) can show show / update "Expand Implicit Hints" state
  // You may right-click on the hint and see / update "Expand Implicit Hints" state
  // Hover mouse cursor over a paren while pressing Ctrl / Cmd to see the matched pair

  {
    class A; class B; class C; class D
    implicit def aFromB(implicit b: B): A = new A
    implicit def bFromC(implicit c: C): B = new B
    // Comment the following line to reveal a nested missing argument error
    implicit val someC: C = new C

    // Uncomment the above line and the following line to show a nested ambiguous arguments error
    implicit val anotherC: C = new C
    implicit val someD: D = new D
    def materializeB(implicit a: A, d: D): B = new B
    materializeB
  }
  // Scala Standard Library examples
  Seq(1, 2, 3).sorted
  Seq(1, 2, 3).map(_ + 1)
  "abc".map(_.toInt)
  "abc".map(_.toUpper)
}