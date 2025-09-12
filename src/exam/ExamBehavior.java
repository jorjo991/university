package exam;

import administration.Printable;
import course.Course;
import professor.Professor;
import room.Room;
import student.Student;

public interface ExamBehavior {
    void  startExam(Professor professor, Student [ ] students, Room room);
    void  endExam(Room room);
    Result [] getResults(Course course, Student [] students);

}
