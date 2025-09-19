package course;

import registration.Registrable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Faculty implements Registrable {

    private final String name;
    private int id;
    private Set<Course> courses = new HashSet<>();

    public Faculty(String name, int id) {
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
        return id == faculty.id && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void register() {
        System.out.println(this.getName() + "is register As a faculty");
    }
}
