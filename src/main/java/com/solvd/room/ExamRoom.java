package com.solvd.room;

import java.util.function.Supplier;

public class ExamRoom extends Room {

    public ExamRoom(String id, Integer capacity, Boolean available) {
        super(id, capacity, available);
    }

    public ExamRoom supplyNewExamRoom(Supplier<ExamRoom> examRoomSupplier) {
        ExamRoom room = examRoomSupplier.get();
        if (room.getId() != null && capacity > 0) {
            return room;
        }
        throw new RuntimeException("Can Create another Room");
    }

    @Override
    public String toString() {
        return "ExamRoom{" +
                "id='" + id + '\'' +
                ", capacity=" + capacity +
                ", available=" + available +
                '}';
    }
}
