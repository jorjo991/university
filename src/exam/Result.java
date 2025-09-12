package exam;

import administration.Printable;
import course.Course;
import student.Student;

public class Result {
    private Student student;
    private Course course;
    private double result;


    public Result(Student student, Course course, double result) {
        this.student = student;
        this.course = course;
        this.result = result;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
