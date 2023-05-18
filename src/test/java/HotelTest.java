import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class HotelTest {
    private Hotel hotel;
    private ConferenceRoom conferenceRoom;
    private Bedroom bedroom;
    private Bedroom bedroom2;
    private Guest jingwen;
    private Guest wenjing;
    private Guest jiajia;

    @Before
    public void setUp(){
        hotel = new Hotel();
        conferenceRoom = new ConferenceRoom(16, "The Jiajia Room");
        bedroom = new Bedroom(RoomType.TRIPLE, 101, 30.00);
        bedroom2 = new Bedroom(RoomType.DOUBLE, 102, 20.00);
        jingwen = new Guest("Jingwen");
        wenjing = new Guest("Wenjing");
        jiajia = new Guest("Jiajia");


    }

    @Test
    public void roomListsStartEmpty() {
        assertEquals(0, hotel.getBedrooms().size());
        assertEquals(0, hotel.getConferenceRooms().size());
    }

    @Test
    public void canAddConferenceRoom() {
        hotel.addConferenceRoom(conferenceRoom);
        assertEquals(1, hotel.getConferenceRooms().size());
    }

    @Test
    public void canAddBedroom() {
        hotel.addBedroom((bedroom));
        assertEquals(1, hotel.getBedrooms().size());
    }
    @Test
    public void canCheckGuestIntoBedroom(){
        hotel.addBedroom((bedroom));
        hotel.checkGuestIn(wenjing, bedroom.getRoomNumber());
        assertEquals(1,bedroom.getGuests().size());

    }
    @Test
    public  void canCheckGuestIntoConferenceRoom(){
        hotel.addConferenceRoom(conferenceRoom);
        hotel.checkGuestIn(wenjing,"The Jiajia Room");
        assertEquals(1,conferenceRoom.getGuests().size());
    }
    @Test
    public void canCheckOutOfBedroom (){
        hotel.addBedroom((bedroom));
        hotel.checkGuestIn(wenjing, bedroom.getRoomNumber());
        hotel.checkGuestIn(jingwen, bedroom.getRoomNumber());
        hotel.checkGuestOut(jingwen, bedroom.getRoomNumber());
        assertEquals(1,bedroom.getGuests().size());
    }
    @Test
    public void canCheckOutOfConference(){
        hotel.addConferenceRoom(conferenceRoom);
        hotel.checkGuestIn(wenjing,conferenceRoom.getName());
        hotel.checkGuestIn(jingwen,conferenceRoom.getName());
        hotel.checkGuestOut(wenjing, conferenceRoom.getName());
        assertEquals(1, conferenceRoom.getGuests().size());
    }

    @Test
    public void canBookRoom() {
        hotel.addBedroom((bedroom));
        Booking booking = hotel.bookRoom(bedroom.getRoomNumber(), 7);
        assertEquals(7, booking.getNightsBooked());
        assertEquals(101, booking.getBedroom().getRoomNumber());
    }

    @Test
    public void canGetVacantBedrooms() {
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        hotel.checkGuestIn(jiajia, bedroom.getRoomNumber());
        assertEquals(1, hotel.getVacantBedrooms().size());
    }
//    @Test
//    public void canNotCheckInGuestToFullBedroom(){
//        hotel.addBedroom(bedroom2);
//        hotel.checkGuestIn(jiajia, bedroom2.getRoomNumber());
//        hotel.checkGuestIn(wenjing, bedroom2.getRoomNumber());
//        hotel.checkGuestIn(jingwen, bedroom2.getRoomNumber());
//        assertEquals(2, bedroom2.getGuests().size());
//    }

    @Test
    public void canOnlyCheckGuestIntoEmptyBedroom(){
        hotel.addBedroom(bedroom2);
        hotel.checkGuestIn(jiajia, bedroom2.getRoomNumber());
        hotel.checkGuestIn(wenjing, bedroom2.getRoomNumber());
        assertEquals(1, bedroom2.getGuests().size());
    }

}
