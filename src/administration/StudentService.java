package administration;

import course.Course;
import course.Faculty;
import exception.InvalidRegistrationException;
import exception.RegistrationLimitException;
import person.Person;
import student.Student;
import java.util.Arrays;

public class StudentService implements Printable, ReportAble {

    public void registerStudentOnCourse(Student student, Course course) throws RegistrationLimitException, InvalidRegistrationException {
        if (student.getSemester() > 8)
            throw new InvalidRegistrationException("Student is not able to register this course");
        if (course.getStudents().length > 50) throw new RegistrationLimitException("Registration limit Exceeded");
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
