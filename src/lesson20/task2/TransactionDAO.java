package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();



    public Transaction save(Transaction transaction) throws Exception {
        validate(transaction);

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null){
                transactions[i] = transaction;
                return transactions[i];
            }
        }


        throw new InternalServerException("Unexpected error");

    }

    private void validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getlimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can`t be saved");

        int sum = transaction.getAmount();
        int count = 1;

        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() + ". Can`t be saved");

        if (count > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() + ". Can`t be saved");


        boolean cityCheck = false;
        for (String city : utils.getCities()) {
            if (transaction.getCity().equals(city)) {
                cityCheck = true;
                break;
            }
        }
            if (!cityCheck) {
                throw new BadRequestException("Transaction city not wright " + transaction.getId() + ". Can`t be saved");
            }


        boolean freeNull = false;
        for (Transaction tr : transactions) {
            if (tr == null) {
                freeNull = true;
                break;
            }
        }
        if (!freeNull) {
            throw new InternalServerException("Transaction " + transaction.getId() + " don`t have free space. Can`t be saved");
        }


    }

    Transaction[] transactionList() throws Exception {

        int count = 0;
        for (Transaction tr : transactions){
            if (tr != null){
                count++;
            }
        }

//        if (count == 0){
//            throw new BadRequestException("Transaction list is empty" );
//        }

        Transaction[] result  = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions){
            if (tr != null){
                result[index] = tr;
                index++;
            }
        }

        return result;
    }

    Transaction[] transactionList(String city) throws Exception {
        if (city == null)
            throw new BadRequestException("City not set");



        int count = 0;

        for (Transaction tr : transactions) {
            if (tr != null && city.equals(tr.getCity()))
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

//        if (count == 0)
//            throw new BadRequestException("amount not found");

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
