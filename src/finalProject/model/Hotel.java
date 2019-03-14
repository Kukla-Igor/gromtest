package finalProject.model;


public class Hotel extends IdEntity{
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(long id) {
        this.id = id;
    }

    public Hotel(long id, String name, String country, String city, String street) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public Hotel(String name, String country, String city, String street) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getStreet() {
        return street;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + country + ", " + city + ", " + street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (name != null ? !name.equals(hotel.name) : hotel.name != null) return false;
        if (country != null ? !country.equals(hotel.country) : hotel.country != null) return false;
        if (city != null ? !city.equals(hotel.city) : hotel.city != null) return false;
        return street != null ? street.equals(hotel.street) : hotel.street == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        return result;
    }
}
