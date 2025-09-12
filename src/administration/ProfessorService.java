package administration;

import course.Course;
import course.Faculty;
import person.Person;
import professor.Professor;

import java.util.Arrays;

public class ProfessorService  implements  Printable,ReportAble{

    public  void registerProfessorOnCourse(Professor professor, Course course){
        course.registerProfessorOnCourse(professor);
    }
    public  void registerProfessorOnFaculty(Professor professor, Faculty faculty){
        professor.registrationOnFaculty(faculty);
    }
    @Override
    public void print(Administration administration) {
        System.out.println(Arrays.toString(administration.getProfessorRepository().getAll()));
    }

    @Override
    public void report(Person person) {
        System.out.println("Report of" +person.getAge()+"  "+person.getSurname());

    }
    // room for more  functionalities

}
