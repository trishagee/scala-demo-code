sealed trait Event

case class Notification (title: String, body: String) extends Event
case class Warning (severity: Short, title: String, body: String) extends Event
case class Error (code: Short, title: String, log: String) extends Event

def processEvent(event: Event): Unit ={
  event match {
    case Notification(title, body) =>
    case Warning(severity, title, body) =>
    case Error(code, title, log) =>
  }
}