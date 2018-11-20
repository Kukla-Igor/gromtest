package lesson15.homework.Room;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    Room[] requestRooms(int price, int persons, String city, String hotel){
        int lenghtArray = 0;
        for (API api: apis){
            lenghtArray += api.findRooms(price, persons, city, hotel).length;
        }

        Room[] rooms = new Room[lenghtArray];
        Room[] allRooms = apis[0].findRooms(price, persons, city, hotel);
        int lenght = allRooms.length;

        for ( int i = 1; i < apis.length; i++){
            rooms = apis[1].findRooms(price, persons, city, hotel);
            allRooms[lenght + i - 1] = rooms[i - 1];
        }

        return allRooms;
    }

    Room[] check (API api1, API api2){
        Room[] rooms1 = api1.getAll();
        Room[] rooms2  = api2.getAll();

        int length = 0;
        int big = rooms2.length;
        int small = rooms1.length;

        if (small > big) {
            big = rooms1.length;
            small = rooms2.length;
        }

        for (int i = 0; i < big; i++){
            for (int j = 0; j < small; j++){
                if (rooms1[i].equals(rooms2[j])){
                    length++;
                }
            }
        }

        Room[] allRooms = new Room[length];
        int k = 0;


        for (int i = 0; i < big; i++){
            for (int j = 0; j < small; j++){
                if (rooms1[i].equals(rooms2[j])){
                    allRooms[k] = rooms1[i];
                    k++;
                }
            }
        }
        return allRooms;
    }
}
