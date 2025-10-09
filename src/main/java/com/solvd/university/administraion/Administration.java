package com.solvd.university.administraion;

import com.solvd.university.anotation.Execution;
import com.solvd.university.course.Course;
import com.solvd.university.course.Faculty;
import com.solvd.university.exception.InvalidAgeException;
import com.solvd.university.lamdafucntion.AverageCalculator;
import com.solvd.university.lamdafucntion.CountRank;
import com.solvd.university.professor.Professor;
import com.solvd.university.professor.ProfessorRank;
import com.solvd.university.registration.Registrable;
import com.solvd.university.repository.RepositoryImpl;
import com.solvd.university.student.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Administration {

    private RepositoryImpl<Student> studentRepository = new RepositoryImpl<>(new ArrayList<>());
    private RepositoryImpl<Professor> professorRepository = new RepositoryImpl<>(new ArrayList<>());
    private RepositoryImpl<Course> courseRepository = new RepositoryImpl<>(new ArrayList<>());
    private RepositoryImpl<Faculty> facultyRepository = new RepositoryImpl<>(new ArrayList<>());

    private static final Logger LOGGER = LogManager.getLogger(Administration.class.getName());

    static {
        LOGGER.info("Administration class loaded at " + LocalDateTime.now() + " (+04 timezone)");
    }

    public boolean isDuplication(Registrable registrable, List<? extends Registrable> registrableList) {
        return registrableList.stream().
                anyMatch(registrable1 -> registrable1.equals(registrable));
    }

    @Execution(message = "important to execute")
    // register Student in university by Administration
    public void registerStudent(Student student) {
        if (!isDuplication(student, getStudentRepository().getAll())) {
            if (student == null) throw new NullPointerException();
            studentRepository.register(student);
        }
    }

    @Execution(message = "important to execute")
    //register Course in university by Administration
    public void registerCourse(Course course) {
        if (!isDuplication(course, getCourseRepository().getAll())) {
            if (course == null) throw new NullPointerException();
            courseRepository.register(course);
        }
    }

    @Execution(message = "important to execute")
    //register Professor in university by Administration
    public void registerProfessor(Professor professor) {
        if (professor == null) throw new NullPointerException();

        if (!isDuplication(professor, getProfessorRepository().getAll())) {
            if (professor.getAge() >= 100) throw new InvalidAgeException("Invalid Age Detected ");
            professorRepository.register(professor);
        }
    }

    @Execution(message = "important to execute")
    //register Faculty in university by Administration
    public void registerFaculty(Faculty faculty) {
        if (faculty == null) throw new NullPointerException();
        if (!isDuplication(faculty, getFacultyRepository().getAll())) {
            facultyRepository.register(faculty);
        }
    }

    public RepositoryImpl<Student> getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(RepositoryImpl<Student> studentRepository) {
        this.studentRepository = studentRepository;
    }

    public RepositoryImpl<Professor> getProfessorRepository() {
        return professorRepository;
    }

    public void setProfessorRepository(RepositoryImpl<Professor> professorRepository) {
        this.professorRepository = professorRepository;
    }

    public RepositoryImpl<Course> getCourseRepository() {
        return courseRepository;
    }

    public void setCourseRepository(RepositoryImpl<Course> courseRepository) {
        this.courseRepository = courseRepository;
    }

    public RepositoryImpl<Faculty> getFacultyRepository() {
        return facultyRepository;
    }

    public void setFacultyRepository(RepositoryImpl<Faculty> facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    // average age of all student  at University
    public double averageStudentAge(AverageCalculator averageCalculator) {
        if (studentRepository.getAll().isEmpty()) throw new RuntimeException("Student are not presented");
        List<Student> students = studentRepository.getAll();
        students = students.stream().
                filter(x -> x.getAge() > 0).
                toList();

        return averageCalculator.averageAge(students);
    }

    // average age of professor at University
    public double averageProfessorAge(AverageCalculator averageCalculator) {
        if (professorRepository.getAll().isEmpty()) throw new RuntimeException("Professor are not presented");
        List<Professor> professors = professorRepository.getAll();
        professors = professors.stream().
                filter(professor -> professor.isProfessorValid(age -> age > 0 && age < 100)).
                toList();
        return averageCalculator.averageAge(professors);
    }

    public int countProfessorByRank(CountRank countRank, ProfessorRank professorRank) {
        if (getProfessorRepository().getAll().isEmpty()) throw new RuntimeException("Professor is not presented");
        List<Professor> professors = getProfessorRepository().getAll();
        professors = professors.stream().
                filter(professor -> professor.isProfessorValid(age -> age > 0 && age < 100)).
                toList();
        return professors.stream().
                mapToInt(professor -> countRank.countRankOfProfessors(professorRank, professor)).
                sum();

    }
}
