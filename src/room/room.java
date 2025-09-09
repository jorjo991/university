package room;

import java.util.Objects;

public abstract class room {
    protected  String  roomID;
    protected  Integer capacity;
    protected  Boolean isAvailable;


    protected  static  int countRoom;



    public room(String roomID, Integer capacity, Boolean isAvailable) {
        this.roomID = roomID;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
        countRoom+=1;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        room room = (room) o;
        return Objects.equals(roomID, room.roomID) && Objects.equals(capacity, room.capacity) && Objects.equals(isAvailable, room.isAvailable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomID, capacity, isAvailable);
    }
}
