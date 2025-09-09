package exam;


import course.Course;
import student.Student;

public abstract class Exam  {

    private Student [] students;
    private  Course course;

    public Exam(Student[] students, Course course) {
        this.students = students;
        this.course = course;
    }

    public  abstract  Grade [] result(Student [] students);


    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
