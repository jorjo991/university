import java.nio.charset.CoderResult;
import java.util.List;

public class University {

    private  String name;
    private List<Course> courses;
    private List<Student> students;
    private List<Faculty> faculties;
    private List<Professor> professors;


    public   void  addFaculty(Faculty faculty){
        this.faculties.add(faculty);
    }

    public  void addProfessor(Professor professor){
        this.professors.add(professor);
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void  addStudent(Student student){
        this.students.add(student);
    }



    public void  courseOnGoing( Course course){
        System.out.println("CourseName: "+course.getName());
        System.out.println("Students");
        for( int i=0; i <course.getStudents().size(); i++){
            System.out.println(course.getStudents().get(i).getName());
        }

        System.out.println("Professor: "+course.getProfessor().getName() );

    }


    public University(String name, List<Course> courses, List<Student> students, List<Faculty> faculties, List<Professor> professors) {
        this.name = name;
        this.courses = courses;
        this.students = students;
        this.faculties = faculties;
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                ", students=" + students +
                ", faculties=" + faculties +
                ", professors=" + professors +
                '}';
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
}
