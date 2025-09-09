package administration;

import java.util.Arrays;

import course.Course;
import course.Faculty;
import person.Person;
import professor.Professor;
import student.Student;

public class Administration {
    public Course[] courses = new Course[0];
    public Faculty[] faculties = new Faculty[0];
    public Student[] students = new Student[0];
    public Professor[] professors = new Professor[0];


    //polymorphic methods
    public void getInfo(Person person) {
        person.getInfo();
    }

    public boolean isDuplicate(Person person, Person[] persons) {
        if(persons.length<=1) return false;
        for (Person person1 : persons) {
            if (person1.equals(person)) return true;
        }
        return false;
    }

    // adding new student to University
    public void registerStudent(Student student) {
        if (!isDuplicate(student, students)) {
            this.students = Arrays.copyOf(this.students, this.students.length + 1);
            this.students[this.students.length - 1] = student;
        }
    }
    // adding new course to University
    public void courseRegistration(Course course) {
        for (Course course1 : courses) {
            if (course1.equals(course)) return;
        }
        this.courses = Arrays.copyOf(this.courses, this.courses.length + 1);
        this.courses[this.courses.length - 1] = course;
    }

    // adding new professor to University
    public void professorRegistration(Professor professor) {
        if (!isDuplicate(professor, professors)) {
            this.professors = Arrays.copyOf(this.professors, this.professors.length + 1);
            this.professors[this.professors.length - 1] = professor;

        }
    }

    // adding new faculty to  University
    public void addFaculty(Faculty faculty) {
        for (Faculty faculty1 : faculties) {
            if (faculty1.equals(faculty)) return;
        }
        this.faculties = Arrays.copyOf(this.faculties, this.faculties.length + 1);
        this.faculties[this.faculties.length - 1] = faculty;
    }

    // Register student to faculty
    public void registrationStudentOnFaculty(Faculty faculty, Student student) {
        student.setFaculty(faculty);

    }
    // Register Professor to faculty
    public void registrationProfessorOnFaculty(Faculty faculty, Professor professor) {
        professor.registrationOnFaculty(faculty);

    }
    // Register student on course
    public void registerStudentOnCourse(Student student, Course course) {
        for (Course course1 : courses) {
            if (course1.equals(course)) {
                course1.registerStudentOnCourse(student);
            }
        }

    }
     // register professor to course
    public void registerProfessorOnCourse(Professor professor, Course course) {
        for (Course course1 : courses) {
            if (course1.equals(course)) {
                course1.registerProfessorOnCourse(professor);
            }

        }
    }





}
