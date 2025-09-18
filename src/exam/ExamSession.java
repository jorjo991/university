package exam;

import exception.RoomUnavailableException;
import room.Room;

public class ExamSession implements AutoCloseable {

    private final Room room;
    private boolean isActive;

    public ExamSession(Room room) {
        if (room == null || !room.getAvailable()) {
            throw new RoomUnavailableException("Room " + (room != null ? room.getId() : "null") + " is not available");
        }
        this.room = room;
        this.isActive = true;
        System.out.println("Exam session started in Room " + room.getId() + " at " + java.time.LocalDateTime.now() + " (+04 timezone)");
    }

    public void conductExam() {
        if (!isActive) throw new IllegalStateException("Exam session is not active");
        System.out.println("Exam conducted in Room " + room.getId());
    }

    @Override
    public void close() {
        if (isActive) {
            room.setAvailable(true);
            isActive = false;
            System.out.println("Exam session closed in Room " + room.getId() + " at " + java.time.LocalDateTime.now() + " (+04 timezone)");
        }
    }
}