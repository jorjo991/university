package com.solvd.university.course;

import com.solvd.university.administraion.CourseService;
import com.solvd.university.lamdafucntion.CourseFilter;
import com.solvd.university.professor.Professor;
import com.solvd.university.registration.Registrable;
import com.solvd.university.student.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public final class Course implements Registrable {

    private static int countCourse;
    private static final Logger LOGGER = LogManager.getLogger(Course.class.getName());

    private final String name;
    private Professor professorTeacherCourse;
    private Integer credit;
    private List<Student> students = new ArrayList<>();
    private CourseLevel courseLevel;
    private CourseStatus courseStatus;

    public Course(String name, Integer credit, CourseLevel courseLevel, CourseStatus courseStatus) {
        this.name = name;
        this.credit = credit;
        this.courseLevel = courseLevel;
        countCourse += 1;
        this.courseStatus = courseStatus;
    }

    //registration student to Course
    public void registerStudentOnCourse(Student student) {
        students.add(student);
    }

    //registration professor to Course
    public void registerProfessorOnCourse(Professor professor) {
        this.professorTeacherCourse = professor;
    }

    @Override
    public void register() {
        LOGGER.info("Course" + this.getName() + " is Registered");

    }

    //filter course with certain field
    public boolean courseFilter(CourseFilter courseFilter) {
        if (getStudents() != null && getCredit() != null) {
            return courseFilter.test(this);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", professorTeacherCourse=" + professorTeacherCourse +
                ", credit=" + credit +
                ", students=" + students +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) && Objects.equals(professorTeacherCourse, course.professorTeacherCourse) && Objects.equals(credit, course.credit) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, professorTeacherCourse, credit, students);
    }

    public String getName() {
        return name;
    }

    public Professor getProfessorTeacherCourse() {
        return professorTeacherCourse;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public CourseLevel getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(CourseLevel courseLevel) {
        this.courseLevel = courseLevel;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }

    public static int getCountCourse() {
        return countCourse;
    }

    public static void setCountCourse(int countCourse) {
        Course.countCourse = countCourse;
    }

}
