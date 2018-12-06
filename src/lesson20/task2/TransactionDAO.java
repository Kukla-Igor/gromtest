package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServelException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        for (Transaction tr : transactions) {
            if (tr == null)
                return tr = transaction;
        }


        throw new InternalServelException("Unexpected error");

    }

    private void validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitsSimpleTransactionsAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can`t be saved");

        int sum = 0;
        int count = 0;

        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can`t be saved");

        if (count > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can`t be saved");

        for (String city : utils.getCities()) {
            if (city == transaction.getCity()) {
                break;
            }
            throw new BadRequestException("Transaction city not wright " + transaction.getId() + ". Can`t be saved");

        }

        for (Transaction tr : transactions) {
            if (tr == null)
                break;
        }
        throw new InternalServelException("Transaction " + transaction.getId() + "don`t have free space. Can`t be saved");

    }

    Transaction[] transactionList() {
        return transactions;
    }

    Transaction[] transactionList(String city) throws Exception {
        if (city == null)
            throw new BadRequestException("City not set");

        int count = 0;

        for (Transaction tr : transactions) {
            if (city.equals(tr.getCity()))
                count++;
        }

        if (count == 0)
            throw new BadRequestException("City not found");

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions) {
            if (city.equals(tr.getCity())) {
                result[index] = tr;
                index++;
            }
        }
        return result;
    }

    Transaction[] transactionList(int amount) throws Exception {

        int count = 0;

        for (Transaction tr : transactions) {
            if (tr != null) {
                if (amount == tr.getAmount())
                    count++;
            }
        }

        if (count == 0)
            throw new BadRequestException("City not found");

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                if (amount == tr.getAmount()) {
                    result[index] = tr;
                    index++;
                }
            }
        }
        return result;
    }


    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(dateOfCurTransaction);
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(dateOfCurTransaction);
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }

        return result;

    }
}
