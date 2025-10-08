package com.solvd.university.administraion;

import com.solvd.university.course.Course;
import com.solvd.university.course.CourseStatus;
import com.solvd.university.exception.DuplicateEntityException;
import com.solvd.university.exception.InvalidRegistrationException;
import com.solvd.university.exception.RegistrationLimitException;
import com.solvd.university.student.Student;
import com.solvd.university.person.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.stream.Collectors;

public class StudentService implements Printable, Reportable<Student> {

    private Map<Student, List<Course>> studentAttendCourse = new HashMap<>();

    private static final Logger LOGGER = LogManager.getLogger(StudentService.class.getName());

    public final void registerStudentOnCourse(Student student, Course course) throws RegistrationLimitException {
        if (course.getStudents().contains(student)) throw new DuplicateEntityException("Duplicated Student Detected");
        if (course.getCourseStatus().equals(CourseStatus.CLOSED))
            throw new InvalidRegistrationException("Student is not able to register this course");
        if (course.getStudents().size() > 50) throw new RegistrationLimitException("Registration limit Exceeded");
        course.registerStudentOnCourse(student);
        List<Course> courses = studentAttendCourse.getOrDefault(student, new ArrayList<>());
        courses.add(course);
        studentAttendCourse.put(student, courses);
    }

    @Override
    public void print(Administration a) {
        LOGGER.info(a.getStudentRepository().getAll());
    }

    @Override
    public final void report(Student student) {
        LOGGER.info("Report of " + student.getName() + " " + student.getSurname());
    }

    public List<Course> StudentStudyCourses(Student student) {
        if (!studentAttendCourse.containsKey(student)) return null;
        return studentAttendCourse.get(student);
    }

    public Map<Student, List<Course>> getStudentAttendCourse() {
        return studentAttendCourse;
    }

    public int calculateStudentPerformance(Function<Student, Integer> studentIntegerFunction, Student student) {
        if (student != null) {
            if (studentAttendCourse.containsKey(student)) {
                return studentIntegerFunction.apply(student);
            }
        }
        throw new RuntimeException("Invalid Student");
    }

    public double calculateStudentScoreOnCourse(Student student, Course course, ToDoubleBiFunction<Student, Course> toDoubleBiFunction) {
        if (student != null && course != null) {
            if (getStudentAttendCourse().containsKey(student) && getStudentAttendCourse().get(student).contains(course)) {
                return toDoubleBiFunction.applyAsDouble(student, course);
            }
        }
        throw new RuntimeException("Student does not match to course");
    }

    public int calculateCreditScore(Student student, BinaryOperator<Integer> binaryOperator) {
        if (student != null) {
            if (student.getCredits() != 0 && student.getSemester() != 0) {
                return binaryOperator.apply(student.getCredits(), student.getSemester());
            }
        }
        throw new RuntimeException("Invalid Student Info");
    }

    public List<String> getStudentsNameOnCourse(Course course, Administration administration) {
        if (!administration.getCourseRepository().getAll().contains(course))
            throw new RuntimeException("Invalid Course Detected");
        return course.getStudents().stream().
                map(Student::getName).
                toList();
    }

    public Map<Integer, List<Student>> groupStudentsByAGe(Administration administration) {
        return administration.getStudentRepository().getAll().stream().
                collect(Collectors.groupingBy(Person::getAge));
    }
}
