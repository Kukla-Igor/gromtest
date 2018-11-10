package lesson12;

public class ChinaBank extends Bank {
    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USD)
            return 100;
        return 150;
    }

    @Override
    public int getLimitOfFunding() {

        if (getCurrency() == Currency.EUR)
            return 5000;
        return 10000;    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.EUR)
            return 0;
        else
            return 0.01;
    }

    @Override
    public double getCommission(int amount) {
        if (getCurrency() == Currency.USD){
            if (amount <= 1000)
                return 0.03;
            else
                return 0.05;
        }
        else {
            if (amount <= 1000)
                return 0.1;
            else
                return 0.11;
        }
    }

    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalaryOfEmployee, rating, totalCapital);


    }
}
