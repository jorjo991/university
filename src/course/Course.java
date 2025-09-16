package course;

import professor.Professor;
import registration.Registrable;
import student.Student;
import java.util.Arrays;
import java.util.Objects;

public final class Course implements Registrable {
    private final String name;
    private Professor professorTeacherCourse;
    private Integer credit;
    private Student[] students = new Student[0];
    private Faculty belongsFaculty;
    private int countCourse;

    public Course(String name, Integer credit) {
        this.name = name;
        this.credit = credit;
    }

    //registration student to Course
    public void registerStudentOnCourse(Student student) {
        this.students = Arrays.copyOf(this.students, this.students.length + 1);
        this.students[this.students.length - 1] = student;

    }

    //registration professor to Course
    public void registerProfessorOnCourse(Professor professor) {
        this.professorTeacherCourse = professor;
    }

    //assign to  Faculty of this course
    public void assignFaculty(Faculty faculty) {
        this.belongsFaculty = faculty;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", professorTeacherCourse=" + professorTeacherCourse +
                ", credit=" + credit +
                ", students=" + Arrays.toString(students) +
                ", belongsFaculty=" + belongsFaculty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) && Objects.equals(professorTeacherCourse, course.professorTeacherCourse) && Objects.equals(credit, course.credit) && Objects.deepEquals(students, course.students) && Objects.equals(belongsFaculty, course.belongsFaculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, professorTeacherCourse, credit, Arrays.hashCode(students), belongsFaculty);
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

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Faculty getBelongsFaculty() {
        return belongsFaculty;
    }

}
