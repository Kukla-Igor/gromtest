package lesson11.homework;

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
        Room[] rooms1 = new Room[api1.getAll().length];
        Room[] rooms2 = new Room[api2.getAll().length];
        int length = 0;
        int big = rooms2.length;
        int small = rooms1.length;

        if (rooms1.length > rooms2.length) {
            big = rooms1.length;
            small = rooms2.length;
        }

        for (int i = 0; i < big; i++){
            for (int j = 0; j < small; j++){
                if (rooms1[i].getHotelName() == rooms2[j].getHotelName() && rooms1[i].getCityName() == rooms2[j].getCityName() && rooms1[i].getPersons() == rooms2[j].getPersons() && rooms1[i].getPrice() == rooms2[j].getPrice()){
                    length++;
                }
            }
        }

        Room[] allRooms = new Room[length];
        int k = 0;


        for (int i = 0; i < big; i++){
            for (int j = 0; j < small; j++){
                if (rooms1[i].getHotelName() == rooms2[j].getHotelName() && rooms1[i].getCityName() == rooms2[j].getCityName() && rooms1[i].getPersons() == rooms2[j].getPersons() && rooms1[i].getPrice() == rooms2[j].getPrice()){
                    allRooms[k] = rooms1[i];
                    k++;
                }
            }
        }
        return allRooms;
    }
}
