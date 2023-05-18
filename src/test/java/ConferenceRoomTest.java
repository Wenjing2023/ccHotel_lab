import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {
    private ConferenceRoom conferenceRoom;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom(1000, "The Keith Douglas Room");
    }

    @Test
    public void canGetCapacity() {
        assertEquals(1000, conferenceRoom.getCapacity());
    }

    @Test
    public void canGetName() {
        assertEquals("The Keith Douglas Room", conferenceRoom.getName());
    }
}
