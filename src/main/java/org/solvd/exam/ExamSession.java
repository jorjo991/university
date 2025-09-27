package org.solvd.exam;

import org.solvd.exception.RoomUnavailableException;
import org.solvd.room.Room;

public class ExamSession implements AutoCloseable {

    private final Room room;
    private boolean active;

    public ExamSession(Room room) {
        if (room == null || !room.getAvailable()) {
            throw new RoomUnavailableException("Room " + (room != null ? room.getId() : "null") + " is not available");
        }
        this.room = room;
        this.active = true;
        System.out.println("Exam session started in Room " + room.getId() + " at " + java.time.LocalDateTime.now() + " (+04 timezone)");
    }

    public void conductExam() {
        if (!active) throw new IllegalStateException("Exam session is not active");
        System.out.println("Exam conducted in Room " + room.getId());
    }

    @Override
    public void close() {
        if (active) {
            room.setAvailable(true);
            active = false;
            System.out.println("Exam session closed in Room " + room.getId() + " at " + java.time.LocalDateTime.now() + " (+04 timezone)");
        }
    }
}