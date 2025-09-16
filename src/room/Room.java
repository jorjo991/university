package room;

import java.util.Objects;

public abstract class Room {
    protected  String  roomID;
    protected  Integer capacity;
    protected  Boolean isAvailable;

    protected  static  int countRoom;

    public Room(String roomID, Integer capacity, Boolean isAvailable) {
        this.roomID = roomID;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
        countRoom+=1;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomID, room.roomID) && Objects.equals(capacity, room.capacity) && Objects.equals(isAvailable, room.isAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomID, capacity, isAvailable);
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public static int getCountRoom() {
        return countRoom;
    }

    public static void setCountRoom(int countRoom) {
        Room.countRoom = countRoom;
    }
}
