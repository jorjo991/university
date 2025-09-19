package main;

import administration.*;
import course.Course;
import course.Faculty;
import exam.*;
import person.Gender;
import professor.Professor;
import room.ExamRoom;
import student.Student;
import university.University;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Administration administration = new Administration();
        University university = new University("KIU");

        //professor
        Professor prof1 = new Professor(1, 45, "Alice", "Smith", Gender.FEMALE, "Computer Science");
        Professor prof2 = new Professor(2, 50, "Bob", "Johnson", Gender.MALE, "Mathematics");
        Professor prof3 = new Professor(3, 38, "Clara", "Williams", Gender.FEMALE, "Physics");

        //Courses
        Course math = new Course("Mathematics", 6);
        Course cs = new Course("Computer Science", 8);
        Course physics = new Course("Physics", 5);

        //Students
        Student alice = new Student(1, 20, "Alice", "Brown", Gender.FEMALE, LocalDate.of(2005, 1, 10), true, 2, 30);
        Student bob = new Student(2, 21, "Bob", "Smith", Gender.MALE, LocalDate.of(2004, 3, 15), false, 3, 40);
        Student clara = new Student(3, 22, "Clara", "Johnson", Gender.FEMALE, LocalDate.of(2003, 5, 20), true, 4, 50);
        Student david = new Student(4, 19, "David", "Williams", Gender.MALE, LocalDate.of(2006, 7, 25), false, 1, 20);
        Student eva = new Student(5, 23, "Eva", "Taylor", Gender.FEMALE, LocalDate.of(2002, 9, 30), true, 5, 60);
        Student frank = new Student(6, 20, "Frank", "Miller", Gender.MALE, LocalDate.of(2005, 11, 12), false, 2, 35);
        Student grace = new Student(7, 21, "Grace", "Davis", Gender.FEMALE, LocalDate.of(2004, 2, 8), true, 3, 45);
        Student henry = new Student(8, 22, "Henry", "Wilson", Gender.MALE, LocalDate.of(2003, 4, 18), false, 4, 55);
        Student isabella = new Student(9, 19, "Isabella", "Moore", Gender.FEMALE, LocalDate.of(2006, 6, 22), true, 1, 25);
        Student jack = new Student(10, 23, "Jack", "Taylor", Gender.MALE, LocalDate.of(2002, 8, 14), false, 5, 65);

        //Faculties
        Faculty scienceFaculty = new Faculty("Science Faculty", 1);
        Faculty engineeringFaculty = new Faculty("Engineering Faculty", 2);

        FacultyService facultyService = new FacultyService();
        facultyService.registerFacultyOnUniversity(scienceFaculty, university);
        facultyService.registerFacultyOnUniversity(engineeringFaculty, university);

        // register student on course

        StudentService studentService = new StudentService();
        try {
            studentService.registerStudentOnCourse(alice, math);
            studentService.registerStudentOnCourse(bob, math);
            studentService.registerStudentOnCourse(clara, math);

            studentService.registerStudentOnCourse(david, cs);
            studentService.registerStudentOnCourse(eva, cs);
            studentService.registerStudentOnCourse(frank, cs);
            studentService.registerStudentOnCourse(grace, cs);

            studentService.registerStudentOnCourse(henry, physics);
            studentService.registerStudentOnCourse(isabella, physics);
            studentService.registerStudentOnCourse(jack, physics);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        CourseService courseService = new CourseService();

        courseService.registerCourseOnFaculty(math, scienceFaculty);
        courseService.registerCourseOnFaculty(cs, scienceFaculty);
        courseService.registerCourseOnFaculty(physics, engineeringFaculty);

        ProfessorService professorService = new ProfessorService();

        //register professor on course
        professorService.registerProfessorOnCourse(prof1, math);
        professorService.registerProfessorOnCourse(prof2, cs);
        professorService.registerProfessorOnCourse(prof3, physics);

        //register student, professor, course and faculties
        try {
            // Register professors
            administration.registerProfessor(prof1);
            administration.registerProfessor(prof2);
            administration.registerProfessor(prof3);

            // Register courses
            administration.registerCourse(math);
            administration.registerCourse(cs);
            administration.registerCourse(physics);

            // Register students
            administration.registerStudent(alice);
            administration.registerStudent(bob);
            administration.registerStudent(clara);
            administration.registerStudent(david);
            administration.registerStudent(eva);
            administration.registerStudent(frank);
            administration.registerStudent(grace);
            administration.registerStudent(henry);
            administration.registerStudent(isabella);
            administration.registerStudent(jack);

            // Register faculties
            administration.registerFaculty(scienceFaculty);
            administration.registerFaculty(engineeringFaculty);

        } catch (RuntimeException e) {
            System.out.println("Error registering professor: " + e.getMessage());
        }

        System.out.println(administration.getStudentRepository().getAll());

        //print all faculties ->courses-> students and professor
        System.out.println(university.getName());
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("Faculty: " + faculty.getName());
            System.out.println();
            for (Course course : scienceFaculty.getCourses()) {
                System.out.println("Course: " + course.getName());
                System.out.println("Professor teaches course: " + course.getProfessorTeacherCourse().getName());

                for (Student student : course.getStudents()) {
                    System.out.println("Student: " + student.getName());
                }
                System.out.println();
            }
        }

        //create Exam
        ExamRoom room101 = new ExamRoom("Room101", 30, true);
        ExamRoom room102 = new ExamRoom("Room102", 50, true);

        Student[] finalExamStudents = new Student[]{alice, bob, clara};
        FinalExam exam = new FinalExam(finalExamStudents, math);
        exam.startExam(prof1, finalExamStudents, room101);
        exam.endExam(room101);
        System.out.println("Exam result");
        Result[] results = exam.getResults(math, finalExamStudents);
        for (Result result : results) {
            System.out.println(result.getStudent().getName() + " " + result.getCourse().getName() + " " + result.getResult());
        }

        //print all student at university
        studentService.print(administration);

        //report about one student
        studentService.report(bob);

        //print course
        courseService.print(administration);
    }
}