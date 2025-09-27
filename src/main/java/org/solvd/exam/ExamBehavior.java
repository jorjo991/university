package org.solvd.exam;

import org.solvd.course.Course;
import org.solvd.professor.Professor;
import org.solvd.room.Room;
import org.solvd.student.Student;

import java.util.List;

public interface ExamBehavior {

    void startExam(Professor professor, List<Student> students, Room room);

    void endExam(Room room);

    List<Result> getResults(Course course, List<Student> students);

}
