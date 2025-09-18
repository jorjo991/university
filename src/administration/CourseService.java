package administration;

import course.Course;
import course.Faculty;

public class CourseService implements Printable {

    public void registerCourseOnFaculty(Course course, Faculty faculty) {
        faculty.addCourseOnFaculty(course);
    }

    @Override
    public void print(Administration administration) {
        System.out.println(administration.getCourseRepository().getAll());
    }
    // room for more  functionalities
}
