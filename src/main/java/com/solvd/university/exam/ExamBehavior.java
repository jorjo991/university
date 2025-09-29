package com.solvd.university.exam;

import com.solvd.university.course.Course;
import com.solvd.university.professor.Professor;
import com.solvd.university.room.Room;
import com.solvd.university.student.Student;

import java.util.List;

public interface ExamBehavior {

    void startExam(Professor professor, List<Student> students, Room room);

    void endExam(Room room);

    List<Result> getResults(Course course, List<Student> students);

}
