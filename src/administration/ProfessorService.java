package administration;

import course.Course;
import person.Person;
import professor.Professor;

public class ProfessorService implements Printable, ReportAble {

    public final void registerProfessorOnCourse(Professor professor, Course course) {
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
