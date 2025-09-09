package exam;

import course.Course;
import student.Student;

import java.util.Random;

public class FinalExam extends  Exam{

    public FinalExam(Student [] students, Course course) {
        super(students,course);

    }

    @Override
    public Grade[] result(Student [] students) {
        Grade [] grades= new Grade[students.length];
        for( int i=0; i<students.length; i++){
            grades[i]= new Grade(students[i],Math.random()*100);

        }
       return grades;
    }

    public void printGrades(){
        Grade [ ] result= result(getStudents());
        for(Grade grade: result){
            System.out.println(grade.getStudent().getName()+" "+grade.getExamResult());
        }
    }
}
