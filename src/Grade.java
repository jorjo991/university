public class Grade {
    private  Student student;
    private  Professor professor;
    private  int grade;


    public Grade(Student student, Professor professor, int grade) {
        this.student = student;
        this.professor = professor;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "student=" + student +
                ", professor=" + professor +
                ", grade=" + grade +
                '}';
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

