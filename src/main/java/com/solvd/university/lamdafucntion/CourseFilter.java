package com.solvd.university.lamdafucntion;

import com.solvd.university.course.Course;

@FunctionalInterface
public interface CourseFilter {

    boolean test(Course course);
}
