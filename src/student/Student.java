package student;

import administration.StudentService;
import course.Course;
import exception.InvalidRegistrationException;
import exception.RegistrationLimitException;
import person.Gender;
import person.Person;

import java.time.LocalDate;

public final class Student extends Person {

    private static int countStudent;

    private final LocalDate date;
    private Boolean scholarship;
    private Integer semester;
    private Integer credits;

    public Student(Integer id, Integer age, String name, String surname, Gender gender, LocalDate dateOfBirt, Boolean scholarship, Integer semester, Integer credits) {
        super(id, age, name, surname, gender);
        this.date = dateOfBirt;
        this.scholarship = scholarship;
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

    // info about passed Scholarship
    public Boolean getScholarship() {
        return scholarship;
    }

    public void setScholarship(Boolean hasScholarship) {
        this.scholarship = hasScholarship;
    }

    // info about semester
    public Integer getSemester() {
        return semester;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" +
                "dateOfBirt=" + date +
                ", hasScholarship=" + scholarship +
                ", semester=" + semester +
                ", passedCourse=" +
                ", credits=" + credits +
                '}';
    }

    public static int getCountStudent() {
        return countStudent;
    }

    public static void setCountStudent(int countStudent) {
        Student.countStudent = countStudent;
    }
}
