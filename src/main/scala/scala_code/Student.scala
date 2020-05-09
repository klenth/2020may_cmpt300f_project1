package scala_code

class Student(var name: String, var email: String) {
  override def toString: String = {
    name + " (" + email + ")"
  }
}
