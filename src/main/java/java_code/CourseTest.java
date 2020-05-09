package java_code;

import java.util.List;

public class CourseTest {

    public static void main(String[] args) {
        Course course = makeCourse();
        // Print course enrollment!
        for (Student student : course.getStudents())
            System.out.println(student);
    }

    private static Course makeCourse() {
        Student john = new Student("John Sheridan", "jsheridan@earthforce.earth.gov");
        Student delenn = new Student("Delenn", null);
        Student michael = new Student("Michael Garibaldi", "mgaribaldi@earthforce.earth.gov");
        List<Student> students = List.of(john, delenn, michael);

        Course course = new Course("CMPT 300F", "Functional Programming", students);
        return course;
    }
}
