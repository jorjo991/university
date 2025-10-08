package com.solvd.university.administraion;

import com.solvd.university.course.Course;
import com.solvd.university.course.Faculty;
import com.solvd.university.exception.DuplicateEntityException;
import com.solvd.university.lamdafucntion.AverageCalculator;
import com.solvd.university.student.Student;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.function.Predicate;

public class CourseService implements Printable {

    private static final Logger LOGGER = LogManager.getLogger(CourseService.class.getName());

    public void registerCourseOnFaculty(Course course, Faculty faculty) {
        if (faculty.getCourses().contains(course)) throw new DuplicateEntityException("Duplicated Course Detected");
        faculty.addCourseOnFaculty(course);
    }

    @Override
    public void print(Administration administration) {
        LOGGER.info(administration.getCourseRepository().getAll());
    }

    public double averageStudentAgeOnCourse(AverageCalculator averageCalculator, Course course) {
        if (course != null && !course.getStudents().isEmpty()) {
            List<Student> studentList = course.getStudents();
            studentList = studentList.stream().
                    filter(x -> x.getAge() > 0).
                    toList();
            return averageCalculator.averageAge(studentList);
        }
        return 0;
    }

    public boolean isCourseAvailable(Course course, Predicate<Course> predicate) {
        if (course != null && !course.getStudents().isEmpty()) {
            return predicate.test(course);
        }
        return false;
    }

}
