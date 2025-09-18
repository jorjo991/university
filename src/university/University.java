package university;

import administration.Administration;
import course.Faculty;
import professor.Professor;
import room.Room;

import java.util.Set;

public class University {

    private Administration administration = new Administration();
    private Set<Professor> professors;
    private Set<Room> rooms;
    private Set<Faculty> faculties;

    public University(Administration administration) {
        this.administration = administration;
        this.professors = administration.getProfessorRepository().getAll();
        this.faculties = administration.getFacultyRepository().getAll();
    }

    public Administration getAdministration() {
        return administration;
    }

    public Set<Professor> getProfessors() {
        return professors;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Faculty> getFaculties() {
        return administration.getFacultyRepository().getAll();
    }

}
