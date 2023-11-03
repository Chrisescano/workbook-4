package pluralsight.hotel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testRoomConstructorValues() {
        RoomType roomType = new RoomType();
        Room room = new Room(101, true, true, roomType);
        assertEquals(101, room.number);
    }
}