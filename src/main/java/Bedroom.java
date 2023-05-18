public class Bedroom extends Room{
    private int roomNumber;
    private RoomType roomType;
    private double nightRate;

    public Bedroom(RoomType roomType, int roomNumber, double nightRate) {
        super(roomType.getCapacity());
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.nightRate = nightRate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getNightRate() {
        return nightRate;
    }
}
