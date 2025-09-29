package com.solvd.lamdafucntion;

import com.solvd.course.Course;

@FunctionalInterface
public interface CourseFilter {

    boolean test(Course course);
}
