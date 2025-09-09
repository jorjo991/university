package main;

import administration.Administration;
import administration.Administration;
import course.Course;
import course.Faculty;
import person.Gender;
import person.Person;
import professor.Professor;
import student.Student;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        // Create Administration instance
        Administration admin = new Administration();

        // Create Faculty objects
        Faculty computerScience = new Faculty("Computer Science", 1);
        Faculty mathematics = new Faculty("Mathematics", 2);
        admin.addFaculty(computerScience);
        admin.addFaculty(mathematics); // Test adding same faculty again (duplicate check)
        System.out.println("Faculties after registration: " + java.util.Arrays.toString(admin.faculties));

        // Create Professor objects
        Professor prof1 = new Professor(101, 45, "Dr. Smith", "Johnson", Gender.MALE, "Algorithms");
        Professor prof2 = new Professor(102, 50, "Dr. Lee", "Kim", Gender.FEMALE, "Calculus");
        admin.professorRegistration(prof1);
        admin.professorRegistration(prof1); // Test duplicate professor
        admin.professorRegistration(prof2);
        System.out.println("Professors after registration: " + java.util.Arrays.toString(admin.professors));

        // Register Professors on Faculties
        admin.registrationProfessorOnFaculty(computerScience, prof1);
        admin.registrationProfessorOnFaculty(mathematics, prof2);
        System.out.println("Prof1 Faculties: " + java.util.Arrays.toString(prof1.getFaculties()));

        // Create Course objects
        Course javaCourse = new Course("Introduction to Java", 6);
        Course calculusCourse = new Course("Calculus I", 6);
        Course algorithmsCourse = new Course("Algorithms", 5);
        admin.courseRegistration(javaCourse);
        admin.courseRegistration(javaCourse); // Test duplicate course
        admin.courseRegistration(calculusCourse);
        admin.courseRegistration(algorithmsCourse);
        System.out.println("Courses after registration: " + java.util.Arrays.toString(admin.courses));

        // Assign Faculties to Courses
        javaCourse.assignFaculty(computerScience);
        calculusCourse.assignFaculty(mathematics);
        algorithmsCourse.assignFaculty(computerScience);
        System.out.println("Java Course Faculty: " + javaCourse.getBelongsFaculty().getName());

        // Register Professors on Courses
        admin.registerProfessorOnCourse(prof1, javaCourse);
        admin.registerProfessorOnCourse(prof2, calculusCourse);
        admin.registerProfessorOnCourse(prof1, algorithmsCourse);
        System.out.println("Java Course Professor: " + javaCourse.getProfessorTeacherCourse().getName());

        // Create Student objects
        Student student1 = new Student(1, 20, "Alice", "Smith", Gender.FEMALE, LocalDate.of(2005, 5, 15), true, 3, 30);
        Student student2 = new Student(2, 22, "Bob", "Johnson", Gender.MALE, LocalDate.of(2003, 8, 22), false, 5, 45);
        admin.registerStudent(student1);
        admin.registerStudent(student1); // Test duplicate student
        admin.registerStudent(student2);
        System.out.println("Students after registration: " + java.util.Arrays.toString(admin.students));

        // Register Students on Faculties
        admin.registrationStudentOnFaculty(computerScience, student1);
        admin.registrationStudentOnFaculty(mathematics, student2);
        System.out.println("Student1 Faculty: " + student1.getFaculty().getName());

        // Register Students on Courses
        student1.sendRegistrationRequestONCourse(admin, javaCourse);
        student1.sendRegistrationRequestONCourse(admin, algorithmsCourse);
        student2.sendRegistrationRequestONCourse(admin, calculusCourse);
        System.out.println("Java Course Students: " + java.util.Arrays.toString(javaCourse.getStudents()));

        // Test Polymorphic getInfo
        admin.getInfo(student1); // Calls Student's getInfo
        admin.getInfo(prof1); // Calls Professor's getInfo

        // Additional Test: isDuplicate
        Student duplicateStudent = new Student(1, 20, "Alice", "Smith", Gender.FEMALE, LocalDate.of(2005, 5, 15), true, 3, 30);
        boolean isDup = admin.isDuplicate(duplicateStudent, admin.students);
        System.out.println("Is duplicate student? " + isDup);
    }
}