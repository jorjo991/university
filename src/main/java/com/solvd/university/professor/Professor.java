package com.solvd.university.professor;

import com.solvd.university.administraion.CourseService;
import com.solvd.university.person.Gender;
import com.solvd.university.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.IntPredicate;

public final class Professor extends Person {

    private static final Logger LOGGER = LogManager.getLogger(Professor.class.getName());

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
        LOGGER.info(this.getName() + " " + this.getSurname() + " " + this.getSpecialization());
    }

    public String getSpecialization() {
        return specialization;
    }

    public ProfessorRank getProfessorRank() {
        return professorRank;
    }

    @Override
    public void register() {
        LOGGER.info(this.getName() + "is register");
    }

}
