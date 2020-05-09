package scala_code

class Course(var number: String, var title: String, var students: List[Student]) {

  def getStudentsWith(predicate: Student => Boolean): List[Student] = {
    students.filter(predicate)
  }

  def getStudentsMissingEmails: List[Student] = {
    getStudentsWith(_.email == null)
  }

  override def toString: String = {
    number + ": " + title + " (" + students.size + " enrolled)"
  }

  def compose(f: String => Array[String], g: Array[String] => Int) = f andThen g
}
