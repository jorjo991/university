package administration;

import course.Course;
import exception.InvalidAgeException;
import person.Person;
import professor.Professor;

public class ProfessorService implements Printable, Reportable {

    public final void registerProfessorOnCourse(Professor professor, Course course) {
        if (professor.getAge() > 70) throw new InvalidAgeException("Professor age is not Accepted");
        course.registerProfessorOnCourse(professor);
    }

    @Override
    public void print(Administration administration) {
        System.out.println(administration.getFacultyRepository().getAll());
    }

    @Override
    public void report(Person person) {
        System.out.println("Report of" + person.getAge() + "  " + person.getSurname());

    }
    // room for more  functionalities
}
