package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();
    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;

        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "sdsdc");
     }

    @Override
    public void fund(User user, int amount) {
        if(amount > user.getBank().getLimitOfFunding()) {
            System.err.println("Can`t found money" + amount + " to user" + user.toString());
            return;
        }
        user.setBalance(amount + user.getBalance());

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "sdsdc");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount) || amount > toUser.getBank().getLimitOfFunding() || fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) {
            System.err.println("Can`t transfer money");
            return;
        }

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));

        toUser.setBalance(amount + toUser.getBalance());
        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "sdsdc");

    }

    @Override
    public void paySalary(User user) {
        if(user.getSalary() > user.getBank().getLimitOfFunding()) {
            System.err.println("Can`t pay");
            return;
        }
        user.setBalance(user.getBalance() + user.getSalary());
        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "sdsdc");

    }

    private void printWithdrawalErrorMsg(int amount, User user){
        System.err.println("Can`t withdrawal money" + amount + " from user" + user.toString());
    }

    private boolean checkWithdraw(User user, int amount){
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) && checkWithdrawLimits(user, amount, user.getBalance());

    }

    private boolean checkWithdrawLimits(User user, int amount, double limit){
        if (amount + user.getBank().getCommission(amount) > limit){
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private Transaction createAndSaveTransaction(Date dateCreated, TransactionType type, int amount, String descr){
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreated, null, type,amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
