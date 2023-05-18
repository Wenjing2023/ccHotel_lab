import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RoomTest {



    @Test
    public void canCalculateSize(){
        assertEquals(100.10, Room.calculateSize(10.00,10.01), 0.00);
    }

}
