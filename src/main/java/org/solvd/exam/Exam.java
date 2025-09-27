package org.solvd.exam;

import org.solvd.course.Course;
import org.solvd.student.Student;

import java.util.List;

public abstract class Exam {

    private List<Student> students;
    private Course course;

    public Exam(List<Student> students, Course course) {
        this.students = students;
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

