package com.solvd.university.student;

import com.solvd.university.administraion.CourseService;
import com.solvd.university.administraion.StudentService;
import com.solvd.university.course.Course;
import com.solvd.university.exception.InvalidRegistrationException;
import com.solvd.university.exception.RegistrationLimitException;
import com.solvd.university.person.Gender;
import com.solvd.university.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public final class Student extends Person {

    private static final Logger LOGGER = LogManager.getLogger(Student.class.getName());
    private static int countStudent;

    private final LocalDate date;
    private Boolean scholarship;
    private Integer semester;
    private Integer credits;
    private StudentStatus studentStatus;

    public Student(Integer id, Integer age, String name, String surname, Gender gender, LocalDate dateOfBirt, Boolean scholarship, Integer semester, Integer credits) {
        super(id, age, name, surname, gender);
        this.date = dateOfBirt;
        this.scholarship = scholarship;
        this.credits = credits;
        this.semester = semester;
        countStudent += 1;
        studentStatus = StudentStatus.assignStudentStatus(semester);
    }

    public void sendRegistrationRequestONCourse(StudentService studentService, Course course) throws InvalidRegistrationException {
        try {
            studentService.registerStudentOnCourse(this, course);
        } catch (RegistrationLimitException e) {
            LOGGER.info(e.getMessage());
        } finally {
            LOGGER.info("Student tried to Register");
        }
    }

    public int getCredits() {
        return this.credits;
    }

    @Override
    public void getInfo() {
        LOGGER.info("Student Info: " + this.getName() + " " + this.getSurname() + " " + this.getDateOfBirt());
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

    public LocalDate getDate() {
        return date;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(StudentStatus studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "date=" + date +
                ", scholarship=" + scholarship +
                ", semester=" + semester +
                ", credits=" + credits +
                '}';
    }

    @Override
    public void register() {
        LOGGER.info(this.getName() + "ise register as student");
    }

    public static int getCountStudent() {
        return countStudent;
    }

    public static void setCountStudent(int countStudent) {
        Student.countStudent = countStudent;
    }
}
