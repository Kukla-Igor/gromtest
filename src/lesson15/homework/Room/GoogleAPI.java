package lesson15.homework.Room;

public class GoogleAPI implements API {
    Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int lenght = 0;

        Room findRoom = new Room(0, price, persons, null, city, hotel);

        for (Room room : rooms)
            if (room.equals(findRoom)){
                lenght++;
            }

        int i = 0;
        Room[] allRooms = new Room[lenght];

        for (Room room : rooms)
            if (room.equals(findRoom)){
                allRooms[i] = room;
                i++;
            }
        return allRooms;
    }

    @Override
    public Room[] getAll() {
        int lenght = rooms.length;

        for (Room room : rooms) {
            if (room.getHotelName() == null)
                lenght--;
        }

        Room[] allRooms = new Room[lenght];
        int i = 0;

        for (Room room : rooms) {
            if (room.getHotelName() != null) {
                allRooms[i] = room;
                i++;
            }
        }

        return allRooms;
    }
}
