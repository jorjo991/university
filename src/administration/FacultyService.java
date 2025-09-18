package administration;

import course.Faculty;
import university.University;

public class FacultyService implements Printable {
    public void registerFacultyOnUniversity(Faculty faculty, University university) {
        university.getFaculties().add(faculty);
    }

    @Override
    public void print(Administration administration) {
        System.out.println("all faculties");
        System.out.println(administration.getFacultyRepository().getAll());

    }
    // room for more functionalities
}
