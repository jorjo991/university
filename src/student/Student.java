package student;

import administration.StudentService;
import course.Course;
import course.Faculty;
import exception.InvalidRegistrationException;
import exception.RegistrationLimitException;
import person.Gender;
import person.Person;
import java.time.LocalDate;
import java.util.Arrays;

public final class Student extends Person {
    private final LocalDate date;
    private Faculty faculty;
    private Boolean hasScholarship;
    private Integer semester;
    private Double GPA;
    private Course[] passedCourse;
    private Integer credits;
    private static int countStudent;

    public Student(Integer id, Integer age, String name, String surname, Gender gender, LocalDate dateOfBirt, Boolean hasScholarship, Integer semester, Integer credits) {
        super(id, age, name, surname, gender);
        this.date = dateOfBirt;
        this.hasScholarship = hasScholarship;
        this.credits = credits;
        this.semester = semester;
        countStudent += 1;
    }

    public void sendRegistrationRequestONCourse(StudentService studentService, Course course) throws InvalidRegistrationException {
        try {
            studentService.registerStudentOnCourse(this, course);
        } catch (RegistrationLimitException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getGPA() {
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
        return date;
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

    @Override
    public String toString() {
        return "Student{" +
                "dateOfBirt=" + date +
                ", faculty=" + faculty +
                ", hasScholarship=" + hasScholarship +
                ", semester=" + semester +
                ", GPA=" + GPA +
                ", passedCourse=" + Arrays.toString(passedCourse) +
                ", credits=" + credits +
                '}';
    }
}
