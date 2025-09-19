package administration;

import course.Course;
import course.Faculty;
import exception.InvalidAgeException;
import professor.Professor;
import registration.Registrable;
import repository.RepositoryImpl;
import student.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Administration {

    private RepositoryImpl<Student> studentRepository = new RepositoryImpl<>(new ArrayList<>());
    private RepositoryImpl<Professor> professorRepository = new RepositoryImpl<>(new ArrayList<>());
    private RepositoryImpl<Course> courseRepository = new RepositoryImpl<>(new ArrayList<>());
    private RepositoryImpl<Faculty> facultyRepository = new RepositoryImpl<>(new ArrayList<>());

    static {
        System.out.println("Administration class loaded at " + LocalDateTime.now() + " (+04 timezone)");
    }

    public boolean isDuplication(Registrable registrable, Registrable[] registrableList) {
        for (Registrable registrable1 : registrableList) {
            if (registrable1.equals(registrable)) return true;
        }
        return false;
    }

    // register Student in university by Administration
    public void registerStudent(Student student) {

        if (!isDuplication(student, getStudentRepository().getAll().toArray(new Student[0]))) {
            if (student == null) throw new NullPointerException();
            studentRepository.register(student);
        }
    }

    //register Course in university by Administration
    public void registerCourse(Course course) {
        if (!isDuplication(course, getCourseRepository().getAll().toArray(new Course[0]))) {
            if (course == null) throw new NullPointerException();
            courseRepository.register(course);
        }
    }

    //register Professor in university by Administration
    public void registerProfessor(Professor professor) throws InvalidAgeException {
        if (professor == null) throw new NullPointerException();

        if (!isDuplication(professor, getProfessorRepository().getAll().toArray(new Professor[0]))) {
            if (professor.getAge() >= 100) throw new InvalidAgeException("Invalid Age Detected ");
            professorRepository.register(professor);
        }
    }

    //register Faculty in university by Administration
    public void registerFaculty(Faculty faculty) {
        if (faculty == null) throw new NullPointerException();
        if (!isDuplication(faculty, getFacultyRepository().getAll().toArray(new Faculty[0]))) {
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
}
