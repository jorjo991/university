package com.solvd.university.course;

import com.solvd.university.administraion.CourseService;
import com.solvd.university.registration.Registrable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Faculty implements Registrable {

    private static final Logger LOGGER = LogManager.getLogger(Faculty.class.getName());

    private final String name;
    private Long id;
    private List<Course> courses = new ArrayList<>();

    public Faculty(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public void addCourseOnFaculty(Course course) {
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", facultyID=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void register() {
        LOGGER.info("{}is register As a faculty", this.getName());
    }
}
