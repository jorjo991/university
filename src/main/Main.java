package main;

import administration.Administration;
import administration.CourseService;
import administration.StudentService;
import course.Course;
import course.Faculty;
import exam.FinalExam;
import exam.MidtermExam;
import exam.Result;
import person.Gender;
import professor.Professor;
import room.ExamRoom;
import room.Room;
import student.Student;
import university.University;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Initialize Administration and University
        Administration admin = new Administration();
        University university = new University(admin);

        // Create Rooms
        Room room1 = new ExamRoom("101", 30,true); // Room 101, available
        Room room2 = new ExamRoom("102",35, true); // Room 102, available
        university.setRooms(new Room[]{room1, room2});
        System.out.println("Available Rooms: " + Arrays.toString(university.getRooms()));

        // Create Faculties
        Faculty csFaculty = new Faculty("Computer Science", 1);
        Faculty mathFaculty = new Faculty("Mathematics", 2);
        admin.registerFaculty(csFaculty);
        admin.registerFaculty(mathFaculty);

        System.out.println("Faculties "+ Arrays.toString(university.getFaculties()));


        // Create Professors
        Professor prof1 = new Professor(101, 45, "Dr. Smith", "Johnson", Gender.MALE, "Algorithms");
        Professor prof2 = new Professor(102, 50, "Dr. Lee", "Kim", Gender.FEMALE, "Calculus");
        admin.registerProfessor(prof1);
        admin.registerProfessor(prof2);
        System.out.println("Registered Professors: " + Arrays.toString(university.getProfessor()));
        prof1.getInfo();
        prof2.getInfo();

        // Create Courses
        Course javaCourse = new Course("Introduction to Java", 6);
        Course calculusCourse = new Course("Calculus I", 6);
        admin.registerCourse(javaCourse);
        admin.registerCourse(calculusCourse);
        System.out.println("Registered Courses: " + Arrays.toString(university.getCourse()));

        // Create Students
        Student student1 = new Student(1, 20, "Alice", "Smith", Gender.FEMALE, LocalDate.of(2005, 5, 15), true, 3, 12);
        Student student2 = new Student(2, 22, "Bob", "Johnson", Gender.MALE, LocalDate.of(2003, 8, 22), false, 5, 18);
        admin.registerStudent(student1);
        admin.registerStudent(student2);
        System.out.println("Registered Students: " + Arrays.toString(university.getStudents()));
        student1.getInfo();
        student2.getInfo();


        CourseService courseService= new CourseService();
        courseService.registerCourseOnFaculty(javaCourse,csFaculty);
        courseService.registerCourseOnFaculty(calculusCourse,mathFaculty);
        System.out.println("Courses that belongs faculties");
        Arrays.stream(university.getCourse()).forEach(x-> System.out.println(x.getBelongsFaculty()));


        StudentService studentService= new StudentService();
        studentService.registerStudentOnCourse(student1,javaCourse);
        studentService.registerStudentOnFaculty(student1,csFaculty);
        studentService.registerStudentOnCourse(student2,calculusCourse);
        studentService.registerStudentOnFaculty(student2,mathFaculty);

        System.out.println("Student "+student1.getName()+"studies"+student1.getFaculty());

        Student[] examStudents = {student1, student2};
        FinalExam finalExam = new FinalExam(examStudents, javaCourse);
        MidtermExam midtermExam = new MidtermExam(examStudents, calculusCourse);

        // Start and End Final Exam
        finalExam.startExam(prof1, examStudents, room1);
        System.out.println("Room1 Availability: " + room1.getAvailable());
        finalExam.endExam(room1);
        System.out.println("Room1 Availability after end: " + room1.getAvailable());

        // Get Results
        Result[] finalResults = finalExam.getResults(javaCourse, examStudents);
        System.out.println("Final Exam Results: ");
        for (Result result : finalResults) {
            System.out.println(result.getStudent().getName() + ": " + result.getResult());
        }

        // Start and End Midterm Exam
        midtermExam.startExam(prof2, examStudents, room2);
        System.out.println("Room2 Availability: " + room2.getAvailable());
        midtermExam.endExam(room2);
        System.out.println("Room2 Availability after end: " + room2.getAvailable());

        // Get Results
        Result[] midtermResults = midtermExam.getResults(calculusCourse, examStudents);
        System.out.println("Midterm Exam Results: ");
        for (Result result : midtermResults) {
            System.out.println(result.getStudent().getName() + ": " + result.getResult());
        }

        // print report
        studentService.report(student1);
    }
}