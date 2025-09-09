package exam;

import student.Student;

import java.util.Objects;

public class Grade {
    private Student student;
    private double ExamResult;

    public Grade(Student student, double examResult) {
        this.student = student;
        ExamResult = examResult;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "student=" + student +
                ", ExamResult=" + ExamResult +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Double.compare(ExamResult, grade.ExamResult) == 0 && Objects.equals(student, grade.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, ExamResult);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getExamResult() {
        return ExamResult;
    }

    public void setExamResult(double examResult) {
        ExamResult = examResult;
    }
}

