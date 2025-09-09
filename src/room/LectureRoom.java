package room;
import course.Course;

public class LectureRoom extends room{


    public LectureRoom(String roomID, Integer capacity, Boolean isAvailable) {
        super(roomID, capacity, isAvailable);
    }


    @Override
    public String toString() {
        return "LectureRoom{" +
                "roomID='" + roomID + '\'' +
                ", capacity=" + capacity +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
