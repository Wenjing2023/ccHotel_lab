import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private ArrayList<ConferenceRoom> conferenceRooms;
    private HashMap<Integer,Bedroom> bedrooms;


    public Hotel() {
        this.conferenceRooms = new ArrayList<>();
        this.bedrooms = new HashMap<>();
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRooms.add(conferenceRoom);
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.put(bedroom.getRoomNumber(), bedroom);
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public HashMap<Integer, Bedroom> getBedrooms() {
        return bedrooms;
    }

    public void checkGuestIn(Guest guest, int bedroomNumber) {
        Bedroom bedroom = this.bedrooms.get(bedroomNumber);
        if (bedroom.getGuests().size()==0){
        bedroom.addGuest(guest);}
    }
    private ConferenceRoom findConByName(String conferenceRoomName){
        for(ConferenceRoom room : conferenceRooms){
            if (room.getName()==conferenceRoomName ){
               return room;
            }
        }
        return null;
    }

    public void checkGuestIn(Guest guest, String conferenceRoomName) {
        this.findConByName(conferenceRoomName).addGuest(guest);

    }
    public void checkGuestOut(Guest guest, int bedroomNumber){
        this.bedrooms.get(bedroomNumber).removeGuest(guest);
    }

    public void checkGuestOut(Guest guest, String conferenceRoomName){
        this.findConByName(conferenceRoomName).removeGuest(guest);
    }

    public Booking bookRoom(int bedroomNumber, int nightsToBook) {
        return new Booking(this.getBedrooms().get(bedroomNumber), nightsToBook);
    }

    public HashMap<Integer, Bedroom> getVacantBedrooms() {
        HashMap<Integer, Bedroom> result = new HashMap<>();
        for (Bedroom bedroom : this.bedrooms.values()) {
            if (bedroom.getGuests().size() == 0) {
                result.put(bedroom.getRoomNumber(), bedroom);
            }
        }
        return result;
    }
}
