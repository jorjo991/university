package student;

import administration.Administration;
import course.Course;
import course.Faculty;
import person.Gender;
import person.Person;

import java.time.LocalDate;


public class Student extends Person {
    private final LocalDate dateOfBirt;
    private Faculty faculty;
    private Boolean hasScholarship;
    private Integer semester;
    private Double GPA;
    private Course[] passedCourse;
    private Integer credits;
    private static int countStudent;

    public Student(Integer id, Integer age, String name, String surname, Gender gender, LocalDate dateOfBirt, Boolean hasScholarship, Integer semester, Integer credits) {
        super(id, age, name, surname, gender);
        this.dateOfBirt = dateOfBirt;
        this.hasScholarship = hasScholarship;
        this.credits = credits;
        this.semester = semester;
        countStudent += 1;
    }


    public void sendRegistrationRequestONCourse(Administration administration, Course course) {
        administration.registerStudentOnCourse(this, course);
    }

    public void SendRegistrationRequestOnFaculty(Administration administration, Faculty faculty) {
        administration.registrationStudentOnFaculty(faculty, this);
    }


    public double getGPA(Course[] passedCourses) {
        return this.GPA;
    }

    public Course[] getPassedCourses() {
        return passedCourse;
    }

    public int getCredits() {
        return this.credits;
    }


    @Override
    public void getInfo() {
        System.out.println("Student Info: " + this.getName() + " " + this.getSurname() + " " + this.getDateOfBirt());

    }

    // info about DateOfBirt
    public LocalDate getDateOfBirt() {
        return dateOfBirt;
    }


    // info about passed  Faculty
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty major) {
        this.faculty = major;
    }


    // info about passed Scholarship

    public Boolean getHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(Boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }


    // info about semester
    public Integer getSemester() {
        return semester;
    }


    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void setPassedCourse(Course[] passedCourse) {
        this.passedCourse = passedCourse;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public static int getCountStudent() {
        return countStudent;
    }

    public static void setCountStudent(int countStudent) {
        Student.countStudent = countStudent;
    }


}
