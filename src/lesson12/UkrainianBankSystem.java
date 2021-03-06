package lesson12;

public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;

        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

     }

    @Override
    public void fund(User user, int amount) {
        if(amount > user.getBank().getLimitOfFunding()) {
            System.err.println("Can`t found money" + amount + " to user" + user.toString());
            return;
        }
        user.setBalance(amount + user.getBalance());
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        if (!checkWithdraw(fromUser, amount) || amount > toUser.getBank().getLimitOfFunding() || fromUser.getBank().getCurrency() != toUser.getBank().getCurrency()) {
            System.err.println("Can`t transfer money");
            return;
        }

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));

        toUser.setBalance(amount + toUser.getBalance());

    }

    @Override
    public void paySalary(User user) {
        if(user.getSalary() > user.getBank().getLimitOfFunding()) {
            System.err.println("Can`t pay");
            return;
        }
        user.setBalance(user.getBalance() + user.getSalary());

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
}
