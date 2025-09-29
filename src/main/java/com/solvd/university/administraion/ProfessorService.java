package com.solvd.university.administraion;

import com.solvd.university.course.Course;
import com.solvd.university.exception.InvalidAgeException;
import com.solvd.university.professor.Professor;
import com.solvd.university.professor.ProfessorRank;

import java.util.*;

public class ProfessorService implements Printable, Reportable<Professor> {

    private Map<Professor, List<Course>> professorTeachesCourses = new HashMap<>();

    public final void registerProfessorOnCourse(Professor professor, Course course) {
        if (professor.getAge() > 70) throw new InvalidAgeException("Professor age is not Accepted");
        course.registerProfessorOnCourse(professor);

        List<Course> courses = professorTeachesCourses.getOrDefault(professor, new ArrayList<>());
        courses.add(course);
        professorTeachesCourses.put(professor, courses);
    }

    @Override
    public void print(Administration administration) {
        System.out.println(administration.getFacultyRepository().getAll());
    }

    @Override
    public void report(Professor person) {
        System.out.println("Report of " + person.getName() + "  " + person.getSurname());

    }

    public Map<Professor, List<Course>> getProfessorTeachesCourses() {
        return professorTeachesCourses;
    }

    public boolean isAnyAssociatedProfessor(Administration administration) {
        return administration.getProfessorRepository().getAll().stream().
                anyMatch(x -> x.getProfessorRank().equals(ProfessorRank.ASSOCIATE));
    }

    public List<Professor> getSortedProfessorsByAge(Administration administration) {
        return administration.getProfessorRepository().getAll().stream().
                sorted(Comparator.comparing(Professor::getAge)).
                toList();
    }

    public int getMaxAgeOFProfessor(Administration administration) {
        return administration.getProfessorRepository().getAll().stream().
                max(Comparator.comparing(Professor::getAge)).
                get().
                getAge();
    }
    // room for more  functionalities
}
