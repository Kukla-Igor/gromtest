package lesson20.task2;

public class Utils {
    private int limitTransactionsPerDayCount = 10;
    private int limitTransactionsPerDayAmount = 100;
    private int limitsSimpleTransactionsAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionsPerDayAmount() {
        return limitTransactionsPerDayAmount;
    }

    public int getLimitsSimpleTransactionsAmount() {
        return limitsSimpleTransactionsAmount;
    }

    public String[] getCities() {
        return cities;
    }
}