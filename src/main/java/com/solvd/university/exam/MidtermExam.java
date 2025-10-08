package com.solvd.university.exam;

import com.solvd.university.administraion.CourseService;
import com.solvd.university.course.Course;
import com.solvd.university.exception.RoomUnavailableException;
import com.solvd.university.professor.Professor;
import com.solvd.university.room.Room;
import com.solvd.university.student.GradeScale;
import com.solvd.university.student.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MidtermExam extends Exam implements ExamBehavior {

    private static final Logger LOGGER = LogManager.getLogger(MidtermExam.class.getName());

    public MidtermExam(List<Student> students, Course course) {
        super(students, course);
    }

    @Override
    public void startExam(Professor professor, List<Student> students, Room room) {
        if (!room.getAvailable()) throw new RoomUnavailableException("Room is not available");
        if (professor != null && !students.isEmpty() && room.getAvailable()) {
            room.setAvailable(false);
            LOGGER.info("Exam Started Successfully");
        }
    }

    @Override
    public void endExam(Room room) {
        room.setAvailable(true);
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
