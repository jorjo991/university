package com.solvd.exam;

import com.solvd.course.Course;
import com.solvd.professor.Professor;
import com.solvd.room.Room;
import com.solvd.student.Student;

import java.util.List;

public interface ExamBehavior {

    void startExam(Professor professor, List<Student> students, Room room);

    void endExam(Room room);

    List<Result> getResults(Course course, List<Student> students);

}
