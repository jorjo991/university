import javax.security.auth.Subject;
import java.util.Objects;

public class Minor {
    private  String name;
    private  Subject subject;
    private  String faculty;

    public Minor(String name, Subject subject, String faculty) {
        this.name = name;
        this.subject = subject;
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Minor minor = (Minor) o;
        return Objects.equals(name, minor.name) && Objects.equals(subject, minor.subject) && Objects.equals(faculty, minor.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subject, faculty);
    }
}
