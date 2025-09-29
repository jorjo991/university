package com.solvd.university.exam;

import com.solvd.university.course.Course;
import com.solvd.university.exception.RoomUnavailableException;
import com.solvd.university.professor.Professor;
import com.solvd.university.room.Room;
import com.solvd.university.student.GradeScale;
import com.solvd.university.student.Student;

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
        students.
                forEach(student -> {
                    double result = Math.random() * 100;
                    results.add(new Result(student, course, result, GradeScale.fromGrade(result)));
                });
        return results;
    }
}
