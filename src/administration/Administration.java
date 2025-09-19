package administration;

import course.Course;
import course.Faculty;
import exception.InvalidAgeException;
import professor.Professor;
import repository.RepositoryImpl;
import student.Student;

import java.time.LocalDateTime;
import java.util.HashSet;

public class Administration {

    private RepositoryImpl<Student> studentRepository = new RepositoryImpl<>(new HashSet<>());
    private RepositoryImpl<Professor> professorRepository = new RepositoryImpl<>(new HashSet<>());
    private RepositoryImpl<Course> courseRepository = new RepositoryImpl<>(new HashSet<>());
    private RepositoryImpl<Faculty> facultyRepository = new RepositoryImpl<>(new HashSet<>());

    static {
        System.out.println("Administration class loaded at " + LocalDateTime.now() + " (+04 timezone)");
    }

    // register Student in university by Administration
    public void registerStudent(Student student) {
        if (student == null) throw new NullPointerException();
        studentRepository.register(student);
    }

    //register Course in university by Administration
    public void registerCourse(Course course) {
        if (course == null) throw new NullPointerException();
        courseRepository.register(course);
    }

    //register Professor in university by Administration
    public void registerProfessor(Professor professor) throws InvalidAgeException {
        if (professor == null) throw new NullPointerException();
        if (professor.getAge() >= 100) throw new InvalidAgeException("Invalid Age Detected ");
        professorRepository.register(professor);
    }

    //register Faculty in university by Administration
    public void registerFaculty(Faculty faculty) {
        if (faculty == null) throw new NullPointerException();
        facultyRepository.register(faculty);
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
}
