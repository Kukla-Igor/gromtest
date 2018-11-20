package lesson15.homework.Room;

public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);

    Room[] getAll();
}
