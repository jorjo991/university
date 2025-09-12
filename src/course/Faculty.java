package course;

import exam.FinalExam;
import registration.Registrable;

public class Faculty implements Registrable {
    private final String NAME;
    private  int facultyID;

    public Faculty(String name, int facultyID) {
        this.NAME = name;
        this.facultyID = facultyID;
    }

    public String getName() {
        return NAME;
    }



    public int getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }
}
