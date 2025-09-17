package professor;

import course.Faculty;
import person.Gender;
import person.Person;
import java.util.Arrays;

public final class Professor extends Person {
    private final String specialization;
    private Faculty[] faculties = new Faculty[0];  //  professor is not teaching any faculty.
    // He waits for registration

    public Professor(Integer id, Integer age, String name, String surname, Gender gender, String specialization) {
        super(id, age, name, surname, gender);
        this.specialization = specialization;
    }

    @Override
    public void getInfo() {
        System.out.println(this.getName() + " " + this.getSurname() + " " + this.getSpecialization());
    }

    public void registrationOnFaculty(Faculty faculty) {
        if (this.faculties.length == 0) {
            this.faculties = new Faculty[1];
            this.faculties[0] = faculty;
        } else {
            this.faculties = Arrays.copyOf(this.faculties, this.faculties.length + 1);
            this.faculties[this.faculties.length - 1] = faculty;
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public Faculty[] getFaculties() {
        return faculties;
    }
}
