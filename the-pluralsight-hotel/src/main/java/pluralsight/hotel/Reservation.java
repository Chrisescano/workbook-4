package pluralsight.hotel;

import java.time.LocalDate;
import java.util.List;

public class Reservation {
    LocalDate start;
    LocalDate end;
    Guest guest;
    RoomType requestedType;

    // The following fields are assigned when the guest checks in
    Room room = null;
    Folio folio = null;
    List<RoomKey> keys = null;


    public Reservation() {
    }

    public Reservation(LocalDate start, LocalDate end, Guest guest, RoomType roomType) {
        this.start = start;
        this.end = end;
        this.requestedType = roomType;
        this.guest = guest;
    }
}
