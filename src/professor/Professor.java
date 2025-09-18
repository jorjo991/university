package professor;

import person.Gender;
import person.Person;

public final class Professor extends Person {

    private final String specialization;

    public Professor(Integer id, Integer age, String name, String surname, Gender gender, String specialization) {
        super(id, age, name, surname, gender);
        this.specialization = specialization;
    }

    @Override
    public void getInfo() {
        System.out.println(this.getName() + " " + this.getSurname() + " " + this.getSpecialization());
    }

    public String getSpecialization() {
        return specialization;
    }

}
