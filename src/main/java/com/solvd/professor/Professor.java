package com.solvd.professor;

import com.solvd.person.Gender;
import com.solvd.person.Person;

import java.util.function.IntPredicate;

public final class Professor extends Person {

    private final String specialization;
    private final ProfessorRank professorRank;

    public Professor(Integer id, Integer age, String name, String surname, Gender gender, String specialization, ProfessorRank professorRank) {
        super(id, age, name, surname, gender);
        this.specialization = specialization;
        this.professorRank = professorRank;
    }

    public boolean isProfessorValid(IntPredicate intPredicate) {
        if (getProfessorRank() != null && getSpecialization() != null && getId() != 0) {
            return intPredicate.test(this.getAge());
        }
        return false;
    }

    @Override
    public void getInfo() {
        System.out.println(this.getName() + " " + this.getSurname() + " " + this.getSpecialization());
    }

    public String getSpecialization() {
        return specialization;
    }

    public ProfessorRank getProfessorRank() {
        return professorRank;
    }

    @Override
    public void register() {
        System.out.println(this.getName() + "is register");
    }

}
