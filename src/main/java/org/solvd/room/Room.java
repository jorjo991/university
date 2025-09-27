package org.solvd.room;

import java.util.Objects;

public abstract class Room {

    protected static int countRoom;

    protected String id;
    protected Integer capacity;
    protected Boolean available;

    public Room(String id, Integer capacity, Boolean available) {
        this.id = id;
        this.capacity = capacity;
        this.available = available;
        countRoom += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) && Objects.equals(capacity, room.capacity) && Objects.equals(available, room.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacity, available);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    //static methods
    public static int getCountRoom() {
        return countRoom;
    }

    public static void setCountRoom(int countRoom) {
        Room.countRoom = countRoom;
    }
}
