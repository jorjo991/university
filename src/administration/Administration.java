package administration;

import course.Course;
import course.Faculty;
import person.Person;
import professor.Professor;
import registration.Registrable;
import repository.Repository;
import repository.RepositoryImpl;
import student.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Administration {

     private RepositoryImpl<Student> studentRepository= new RepositoryImpl<>(Student.class);
     private RepositoryImpl<Professor> professorRepository= new RepositoryImpl<>(Professor.class);
     private RepositoryImpl<Course> courseRepository= new RepositoryImpl<>(Course.class);
     private RepositoryImpl<Faculty> facultyRepository= new RepositoryImpl<>(Faculty.class);

    static {
        System.out.println("Administration class loaded at " + LocalDateTime.now() + " (+04 timezone)");
    }

    public static boolean isDuplicatePerson(Registrable registrable, Registrable[] registrables) {
        if(registrables.length<=1) return false;
        for (Registrable registrable1 : registrables) {
            if (registrable1.equals(registrable)) return true;
        }
        return false;
    }
   // register Student in university by Administration
      public  void registerStudent(Student student){
        if(student== null) throw  new NullPointerException();
        if(!isDuplicatePerson(student, studentRepository.getAll())) {
            studentRepository.register(student);
        }

      }
    //register Course in university by Administration
    public  void registerCourse(Course course){
        if(course== null) throw  new NullPointerException();
        if(!isDuplicatePerson(course, courseRepository.getAll())) {
            courseRepository.register(course);
        }

    }
    //register Professor in university by Administration
    public  void registerProfessor(Professor professor){
        if(professor== null)  throw  new NullPointerException();
        if(!isDuplicatePerson(professor, professorRepository.getAll())) {
            professorRepository.register(professor);
        }
    }
    //register Faculty in university by Administration
    public  void registerFaculty(Faculty faculty){
        if(faculty== null)  throw  new NullPointerException();
        if(!isDuplicatePerson(faculty, facultyRepository.getAll())) {
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
