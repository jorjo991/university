public class Classroom {

    private  int roomNumber;
    private  String  roomID;
    private boolean isAvailable;

    public Classroom(int roomNumber, String roomID, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomID = roomID;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
