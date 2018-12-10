package lesson22.homework;

public class Controller {

   // private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception {

        return TransactionDAO.save(transaction);

    }

    Transaction[] transactionList()throws Exception {
        return TransactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) throws Exception {
        return TransactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) throws Exception {
        return TransactionDAO.transactionList(amount);
    }
}
