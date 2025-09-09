package exam;

import course.Course;
import student.Student;

public class MidtermExam extends Exam{


    public MidtermExam(Student[] students, Course course) {
        super(students, course);
    }

    @Override
    public Grade[] result(Student [] students) {

    }
}
