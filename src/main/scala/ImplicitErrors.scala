object ImplicitErrors {

  def acceptBoolean(implicit b: Boolean): Unit = ()

  implicit val maybeTrue: Boolean = true

  acceptBoolean
}

