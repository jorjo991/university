package com.solvd.university.exam;

import com.solvd.university.administraion.CourseService;
import com.solvd.university.exception.RoomUnavailableException;
import com.solvd.university.room.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExamSession implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(ExamSession.class.getName());

    private final Room room;
    private boolean active;

    public ExamSession(Room room) {
        if (room == null || !room.getAvailable()) {
            throw new RoomUnavailableException("Room " + (room != null ? room.getId() : "null") + " is not available");
        }
        this.room = room;
        this.active = true;
        LOGGER.info("Exam session started in Room " + room.getId() + " at " + java.time.LocalDateTime.now() + " (+04 timezone)");
    }

    public void conductExam() {
        if (!active) throw new IllegalStateException("Exam session is not active");
        LOGGER.info("Exam conducted in Room " + room.getId());
    }

    @Override
    public void close() {
        if (active) {
            room.setAvailable(true);
            active = false;
            LOGGER.info("Exam session closed in Room " + room.getId() + " at " + java.time.LocalDateTime.now() + " (+04 timezone)");
        }
    }
}