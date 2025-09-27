package org.solvd.exam;

import org.solvd.course.Course;
import org.solvd.exception.RoomUnavailableException;
import org.solvd.professor.Professor;
import org.solvd.room.Room;
import org.solvd.student.GradeScale;
import org.solvd.student.Student;

import java.util.ArrayList;
import java.util.List;

public class FinalExam extends Exam implements ExamBehavior {

    public FinalExam(List<Student> students, Course course) {
        super(students, course);
    }

    @Override
    public void startExam(Professor professor, List<Student> students, Room room) {
        if (!room.getAvailable()) throw new RoomUnavailableException("Room is not available");
        if (professor != null && !students.isEmpty() && room.getAvailable()) {
            room.setAvailable(false);
            System.out.println("Exam Started Successfully");
        }
    }

    @Override
    public void endExam(Room room) {
        room.setAvailable(true);
        System.out.println("Exam Ended");
    }

    @Override
    public List<Result> getResults(Course course, List<Student> students) {
        List<Result> results = new ArrayList<>();
        students.forEach(student -> {
            double result = Math.random() * 100;
            results.add(new Result(student, course, result, GradeScale.fromGrade(result)));
        });
        return results;
    }
}
