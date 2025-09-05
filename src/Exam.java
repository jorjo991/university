import java.nio.charset.CoderResult;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam  {
    private  List<Grade> grades;
    private  Professor professor;
    private  Course course ;
    private List<Student> students;
    private LocalDate examTime;
    private Classroom classroom;

    //static  part of program
    private  static int examCounter;

    public static int getExamCounter() {
        return examCounter;
    }

    public static void setExamCounter(int examCounter) {
        Exam.examCounter = examCounter;
    }
    //


    // result of exams
    public Map<String, Integer> examResult(List<Student> students){
        Map<String,Integer> result= new HashMap<>();

        for(Student student:students){
            for (Grade grade: grades){
                if (grade.getStudent().getName().equals(student.getName())){
                    result.put(student.getName(),grade.getGrade());

                }
            }
        }

        return  result;

    }

    public Exam(List<Grade> grades, Professor professor, Course course, List<Student> students, LocalDate examTime, Classroom classroom) {
        this.grades = grades;
        this.professor = professor;
        this.course = course;
        this.students = students;
        this.examTime = examTime;
        this.classroom = classroom;
        examCounter+=1;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "grade=" + grades +
                ", professor=" + professor +
                ", course=" + course +
                ", student=" + students +
                ", examTime=" + examTime +
                ", classroom=" + classroom +
                '}';
    }


    public  List<Grade> getGrade() {
        return grades;
    }

    public void setGrade(List<Grade> grades) {
        this.grades = grades;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudent() {
        return students;
    }

    public void setStudent(List<Student> student) {
        this.students = student;
    }

    public LocalDate getExamTime() {
        return examTime;
    }

    public void setExamTime(LocalDate examTime) {
        this.examTime = examTime;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }


}
