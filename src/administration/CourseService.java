package administration;

import course.Course;
import course.Faculty;

import java.util.Arrays;

public class CourseService implements Printable{

    public void registerCourseOnFaculty(Course course, Faculty faculty){
        course.assignFaculty(faculty);
    }

    @Override
    public void print(Administration administration) {
        System.out.println(Arrays.toString(administration.getCourseRepository().getAll()));
    }
    // room for more  functionalities

}
