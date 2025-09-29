package com.solvd.exam;

import com.solvd.course.Course;
import com.solvd.student.GradeScale;
import com.solvd.student.Student;

public class Result {

    private Student student;
    private Course course;
    private double result;
    private GradeScale gradeScale;

    public Result(Student student, Course course, double result, GradeScale gradeScale) {
        this.student = student;
        this.course = course;
        this.result = result;
        this.gradeScale = gradeScale;
    }

    @Override
    public String toString() {

        return "Result{" +
                "student=" + student +
                ", course=" + course +
                ", result=" + result +
                ", gradeScale=" + gradeScale.toString() +
                '}';
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

    public GradeScale getGradeScale() {
        return gradeScale;
    }

    public void setGradeScale(GradeScale gradeScale) {
        this.gradeScale = gradeScale;
    }
}
