package lesson25.homework;


public class Order extends IdEntity{
    private long id;

    public Order(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }
}
