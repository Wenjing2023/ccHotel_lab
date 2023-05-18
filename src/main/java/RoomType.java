public enum RoomType {
    //DOUBLE is a variable
    SINGLE(1),
    DOUBLE(2),
    TRIPLE(3),
    FAMILY(4);

    private final int capacity; //final make sure it won't change

//  In constructor below, this RoomType cannot be public
    RoomType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}


