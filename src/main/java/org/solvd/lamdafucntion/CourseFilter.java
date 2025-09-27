package org.solvd.lamdafucntion;

import org.solvd.course.Course;

@FunctionalInterface
public interface CourseFilter {

    boolean test(Course course);
}
