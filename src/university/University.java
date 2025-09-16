package university;

import administration.Administration;
import course.Course;
import course.Faculty;
import exam.Exam;
import professor.Professor;
import registration.Registrable;
import repository.RepositoryImpl;
import room.Room;
import student.Student;

import java.util.Arrays;
import java.util.Date;

public class University {
    private Administration administration = new Administration();
    private Student[] students;
    private Professor[] professor;
    private Course[] course;
    private Room[] rooms;
    private Faculty[] faculties;

    public University(Administration administration) {
        this.administration = administration;
    }

    public Faculty[] getFaculties() {
        return administration.getFacultyRepository().getAll();
    }

    public void setFaculties(Faculty[] faculties) {
        this.faculties = faculties;
    }

    public Administration getAdministration() {
        return administration;
    }

    public void setAdministration(Administration administration) {
        this.administration = administration;
    }

    public Student[] getStudents() {
        return administration.getStudentRepository().getAll();
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Professor[] getProfessor() {
        return administration.getProfessorRepository().getAll();
    }

    public void setProfessor(Professor[] professor) {
        this.professor = professor;
    }

    public Course[] getCourse() {
        return administration.getCourseRepository().getAll();
    }

    public void setCourse(Course[] course) {
        this.course = course;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
}
