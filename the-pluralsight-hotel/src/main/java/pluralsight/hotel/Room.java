package pluralsight.hotel;

public class Room {
    int number;
    boolean available;
    boolean isClean;
    RoomType roomType;

    public Room(int number, boolean available, boolean isClean, RoomType roomType) {
        this.number = number;
        this.available = available;
        this.isClean = isClean;
        this.roomType = roomType;
    }

    /*-----Getters-----*/
    int getNumberOfBeds() {
       return 1;
    }

    double getPrice() {
        return 0.0;
    }

    boolean isOccupied() {
        return false;
    }

    boolean isDirty() {
        return false;
    }

    boolean isAvailable() {
        return false;
    }
}
