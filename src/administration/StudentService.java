package administration;

import course.Course;
import exception.InvalidRegistrationException;
import exception.RegistrationLimitException;
import person.Person;
import student.Student;

public class StudentService implements Printable, ReportAble {

    public final void registerStudentOnCourse(Student student, Course course) throws RegistrationLimitException, InvalidRegistrationException {
        if (student.getSemester() > 8)
            throw new InvalidRegistrationException("Student is not able to register this course");
        if (course.getStudents().size() > 50) throw new RegistrationLimitException("Registration limit Exceeded");
        course.registerStudentOnCourse(student);
    }

    @Override
    public void print(Administration a) {
        System.out.println(a.getStudentRepository().getAll());

    }

    @Override
    public final void report(Person person) {
        System.out.println("Report of " + person.getName() + " " + person.getSurname());

    }
}
