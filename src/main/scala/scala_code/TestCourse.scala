package scala_code

import java_code.Student

object TestCourse {
  def main(args: Array[String]): Unit = {

    val john = new Student("John Sheridan", "jsheridan@earthforce.earth.gov")
    val delenn = new Student("Delenn", "delenn@gray.minbar.gov")

    //val course = new Course("CMPT 300F", "Functional Programming", List(john, delenn))

    /*
    println(course)
    for (student <- course.getStudents)
      println(student)

    val students = course.getStudents
    for (i <- 0 until students.length)
      println(students(i))

     */
  }
}
