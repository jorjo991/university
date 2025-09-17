package exam;

import course.Course;
import exception.RoomUnavailableException;
import professor.Professor;
import room.Room;
import student.Student;

public class MidtermExam extends Exam implements ExamBehavior {

    public MidtermExam(Student[] students, Course course) {
        super(students, course);
    }

    @Override
    public void startExam(Professor professor, Student[] students, Room room) throws RoomUnavailableException {
        if (!room.getAvailable()) throw new RoomUnavailableException("Room is not available");
        if (professor != null && students.length >= 1 && room.getAvailable()) {
            room.setAvailable(false);
            System.out.println("Exam Started Successfully");
        }
    }

    @Override
    public void endExam(Room room) {
        room.setAvailable(true);

    }

    @Override
    public Result[] getResults(Course course, Student[] students) {
        Result[] results = new Result[students.length];
        for (int i = 0; i < students.length; i++) {
            double result = Math.random() * 100;
            results[i] = new Result(students[i], course, result);
        }
        return results;
    }
}
