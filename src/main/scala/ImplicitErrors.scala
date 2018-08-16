object ImplicitErrors {

  def acceptBoolean(implicit b: Boolean): Unit = ()

  acceptBoolean
}

