package finalProject.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order extends IdEntity {
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public Order(long id, User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }



    @Override
    public String toString() {
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        return id + ", " + this.getUser().getId() + ", " + this.getRoom().getId() + ", " + simple.format(dateFrom) + ", " + simple.format(dateTo) + ", " + moneyPaid;
    }
}
