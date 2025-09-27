package org.solvd.administraion;

import org.solvd.course.Course;
import org.solvd.course.Faculty;
import org.solvd.exception.DuplicateEntityException;
import org.solvd.lamdafucntion.AverageCalculator;
import org.solvd.student.Student;

import java.util.List;
import java.util.function.Predicate;

public class CourseService implements Printable {

    public void registerCourseOnFaculty(Course course, Faculty faculty) {
        if (faculty.getCourses().contains(course)) throw new DuplicateEntityException("Duplicated Course Detected");
        faculty.addCourseOnFaculty(course);
    }

    @Override
    public void print(Administration administration) {
        System.out.println(administration.getCourseRepository().getAll());
    }

    public double averageStudentAgeOnCourse(AverageCalculator averageCalculator, Course course) {
        if (course != null && !course.getStudents().isEmpty()) {
            List<Student> studentList = course.getStudents();
            studentList = studentList.stream().filter(x -> x.getAge() > 0).toList();
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
