import java.util.List;

public class Professor {
    private String name;
    private String surname;
    private int age;
    private List<Course> courses;


    public Professor(String name, String surname, int age, List<Course> courses) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.courses = courses;
    }

    public void  professorTeaches(Course course){
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }







}
