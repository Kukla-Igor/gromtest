package lesson22.homework;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction(0, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(1, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(2, "Odessa", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(3, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction5 = new Transaction(4, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(5, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction7 = new Transaction(6, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(7, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction9 = new Transaction(8, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction10 = new Transaction(9, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());
        Transaction transaction11 = new Transaction(10, "Kiev", 1, "dfdf", TransactionType.INCOME, new Date());

        Controller controller = new Controller();
        TransactionDAO transactionDAO = new TransactionDAO();

        try {
//           System.out.println(controller.save(transaction1));
//            System.out.println(controller.save(transaction2));
//            System.out.println(controller.save(transaction3));
//            System.out.println(controller.save(transaction4));
//            System.out.println(controller.save(transaction5));
//            System.out.println(controller.save(transaction6));
//            System.out.println(controller.save(transaction7));
//            System.out.println(controller.save(transaction8));
//            System.out.println(controller.save(transaction9));
//            System.out.println(controller.save(transaction10));

           // System.out.println(Arrays.toString(transactionDAO.getTransactions()));

            System.out.println(Arrays.toString(controller.transactionList("Odessa")));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
