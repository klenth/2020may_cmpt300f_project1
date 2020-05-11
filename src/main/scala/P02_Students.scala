class P02_Students {

  /*
   * Returns a function (lambda) that takes a Student and returns that student's e-mail.
   */
  def studentEmail(): Student => String = {
    throw new UnsupportedOperationException("Delete this line and replace with your code")
  }

  /*
   * Returns a function (lambda) that takes a Student and returns that student's full name in "Last, First" form.
   * (Like Java/Python, you can concatenate strings using +:
   *   "A" + ", " + "B"
   * constructs the string
   *   "A, B"
   */
  def studentFullName(): Student => String = {
    throw new UnsupportedOperationException("Delete this line and replace with your code")
  }

  /*
   * Returns a function (lambda) that takes a Student and returns true when both cond1 and cond2 return true for that
   * student.
   * For example, if cond1 returns true when the student's email is missing and cond2 returns true when the student
   * missed class, then the the returned function would return true for students whose email is missing and who missed
   * class.
   *
   * Hint: Scala's way of saying "and" is &&, just like in Java.
   */
  def and(cond1: Student => Boolean, cond2: Student => Boolean): Student => Boolean = {
    throw new UnsupportedOperationException("Delete this line and replace with your code")
  }
}
