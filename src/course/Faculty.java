package course;

import registration.Registrable;
import java.util.Objects;

public class Faculty implements Registrable {
    private final String name;
    private int facultyID;

    public Faculty(String name, int facultyID) {
        this.name = name;
        this.facultyID = facultyID;
    }

    public String getName() {
        return name;
    }

    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", facultyID=" + facultyID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return facultyID == faculty.facultyID && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, facultyID);
    }
}
