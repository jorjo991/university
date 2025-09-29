package com.solvd.exam;

import com.solvd.course.Course;
import com.solvd.exception.RoomUnavailableException;
import com.solvd.professor.Professor;
import com.solvd.room.Room;
import com.solvd.student.GradeScale;
import com.solvd.student.Student;

import java.util.ArrayList;
import java.util.List;

public class MidtermExam extends Exam implements ExamBehavior {

    public MidtermExam(List<Student> students, Course course) {
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
