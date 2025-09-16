package administration;

import course.Course;
import course.Faculty;
import person.Person;
import student.Student;

import java.util.Arrays;

public class StudentService implements Printable, ReportAble {

    public void registerStudentOnCourse(Student student, Course course) {
        course.registerStudentOnCourse(student);
    }

    public void registerStudentOnFaculty(Student student, Faculty faculty) {
        student.setFaculty(faculty);
    }

    @Override
    public void print(Administration a) {
        System.out.println(Arrays.toString(a.getStudentRepository().getAll()));

    }
    @Override
    public void report(Person person) {
        System.out.println("Report of " + person.getName() + " " + person.getSurname());

    }
}
