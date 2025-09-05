import java.util.List;
import java.util.Objects;

public class Course {
    private  String name;
    private int courseID;
    private List<Student> students;
    private Professor professor;

    private  static int  countCourse;


    public static int getCountCourse() {
        return countCourse;
    }


    public static void setCountCourse(int countCourse) {
        Course.countCourse = countCourse;
    }

    public Course(String name, int courseID, List<Student> students, Professor professor) {
        this.name = name;
        this.courseID = courseID;
        this.students = students;
        this.professor = professor;
        this.courseID+=1;
        countCourse+=1;
    }

    public  void registration(Student student){
        this.students.add(student);
    }

    public  void removeStudent(Student student){
        this.students.remove(student);
    }








    //getter and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseID == course.courseID && Objects.equals(name, course.name) && Objects.equals(students, course.students) && Objects.equals(professor, course.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, courseID, students, professor);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", courseID=" + courseID +
                ", students=" + students +
                ", professor=" + professor +
                '}';
    }
}
