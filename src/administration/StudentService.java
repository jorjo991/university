package administration;

import course.Course;
import exception.DuplicateEntityException;
import exception.InvalidRegistrationException;
import exception.RegistrationLimitException;
import person.Person;
import student.Student;

public class StudentService implements Printable, Reportable {

    public final void registerStudentOnCourse(Student student, Course course) throws RegistrationLimitException {
        if (course.getStudents().contains(student)) throw new DuplicateEntityException("Duplicated Student Detected");
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
