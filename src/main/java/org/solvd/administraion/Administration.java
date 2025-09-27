package org.solvd.administraion;

import org.solvd.anotation.Execution;
import org.solvd.course.Course;
import org.solvd.course.Faculty;
import org.solvd.exception.InvalidAgeException;
import org.solvd.lamdafucntion.AverageCalculator;
import org.solvd.lamdafucntion.CountRank;
import org.solvd.professor.Professor;
import org.solvd.professor.ProfessorRank;
import org.solvd.registration.Registrable;
import org.solvd.repository.RepositoryImpl;
import org.solvd.student.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Administration {

    private RepositoryImpl<Student> studentRepository = new RepositoryImpl<>(new ArrayList<>());
    private RepositoryImpl<Professor> professorRepository = new RepositoryImpl<>(new ArrayList<>());
    private RepositoryImpl<Course> courseRepository = new RepositoryImpl<>(new ArrayList<>());
    private RepositoryImpl<Faculty> facultyRepository = new RepositoryImpl<>(new ArrayList<>());

    static {
        System.out.println("Administration class loaded at " + LocalDateTime.now() + " (+04 timezone)");
    }

    public boolean isDuplication(Registrable registrable, List<? extends Registrable> registrableList) {
        for (Registrable registrable1 : registrableList) {
            if (registrable1.equals(registrable)) return true;
        }
        return false;
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
        students = students.stream().filter(x -> x.getAge() > 0).toList();
        return averageCalculator.averageAge(students);
    }

    // average age of professor at University
    public double averageProfessorAge(AverageCalculator averageCalculator) {
        if (professorRepository.getAll().isEmpty()) throw new RuntimeException("Professor are not presented");
        List<Professor> professors = professorRepository.getAll();
        professors = professors.stream().filter(x -> x.isProfessorValid(y -> y > 0 && y < 100)).toList();
        return averageCalculator.averageAge(professors);
    }

    public int countProfessorByRank(CountRank countRank, ProfessorRank professorRank) {
        if (getProfessorRepository().getAll().isEmpty()) throw new RuntimeException("Professor is not presented");
        List<Professor> professors = getProfessorRepository().getAll();
        professors = professors.stream().filter(x -> x.isProfessorValid(y -> y > 0 && y < 100)).toList();
        return professors.stream().mapToInt(professor -> countRank.countRankOfProfessors(professorRank, professor)).sum();
    }
}


