package java_code;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Course {

    private String number;
    private String title;
    private List<Student> students;

    public Course(String number, String title, List<Student> students) {
        this.number = number;
        this.title = title;
        this.students = students;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudentsMissingEmails() {
        /*List<java.scala.Student> newList = new ArrayList<>();
        for (java.scala.Student student : students) {
            if (student.getEmail() == null)
                newList.add(student);
        }

        return newList;

         */

        return getStudentsWith(student -> student.getEmail() == null);
    }

    public List<Student> getStudentsWith(Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public String toString() {
        return number + ": " + title + " (" + students.size() + " enrolled)";
    }
}
