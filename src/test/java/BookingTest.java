import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {
    private Bedroom bedroom;
    private Booking booking;

    @Before
    public void before() {
        bedroom = new Bedroom(RoomType.SINGLE, 102, 15.00);
        booking = new Booking(bedroom, 5);
    }

    @Test
    public void canGetTotalBill() {
        assertEquals(75.00, booking.getTotalBill(), 0.00);
    }
}
