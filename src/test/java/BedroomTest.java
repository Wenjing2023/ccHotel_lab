import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    private Bedroom bedroom;
    private Guest guest;

    @Before
    public void setUP(){
        bedroom = new Bedroom(RoomType.DOUBLE, 101, 20.00);
        guest = new Guest("Aneqaa");
    }
    @Test
    public void canAddGuest(){
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.getGuests().size());
    }
    @Test
    public void canClearRoom(){
        bedroom.addGuest(guest);
        bedroom.clearRoom();
        assertEquals(0,bedroom.getGuests().size());
    }
    @Test
    public void canGetRoomType(){
        assertEquals(RoomType.DOUBLE,bedroom.getRoomType());
    }
    @Test
    public void canCalculateSize(){
        assertEquals(121.00,bedroom.calculateSize(11.00,11.00), 0.00 );
    }
}
