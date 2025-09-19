package course;

import professor.Professor;
import registration.Registrable;
import student.Student;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Course implements Registrable {

    private static int countCourse;

    private final String name;
    private Professor professorTeacherCourse;
    private Integer credit;
    private Set<Student> students = new HashSet<>();

    public Course(String name, Integer credit) {
        this.name = name;
        this.credit = credit;
        countCourse += 1;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public static int getCountCourse() {
        return countCourse;
    }

    public static void setCountCourse(int countCourse) {
        Course.countCourse = countCourse;
    }

    @Override
    public void register() {

    }
}
