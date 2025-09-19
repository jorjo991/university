package administration;

import course.Faculty;
import exception.DuplicateEntityException;
import university.University;

public class FacultyService implements Printable {

    public final void registerFacultyOnUniversity(Faculty faculty, University university) {
        if (university.getFaculties().contains(faculty))
            throw new DuplicateEntityException("Duplicated Faculty Detected");
        university.getFaculties().add(faculty);
    }

    @Override
    public void print(Administration administration) {
        System.out.println("all faculties");
        System.out.println(administration.getFacultyRepository().getAll());

    }
    // room for more functionalities
}
