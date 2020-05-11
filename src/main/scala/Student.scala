class Student(val id: String,
              val first: String,
              val last: String,
              val email: String) {

  override def toString(): String = {
    s"[$id] $last, $first ($email)"
  }

}
