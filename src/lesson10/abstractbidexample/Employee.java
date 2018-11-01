package lesson10.abstractbidexample;

public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperience;
    private int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10];
    private String[] positionsWorked = new String[10];
    private String curPosition;

    abstract void paySalary();

    void changePosition(String newPosition) {
        saveCurPositionToHistory();

        curPosition = newPosition;
    }

    private void saveCurPositionToHistory() {
        int index = 0;
        for (String pos: positionsWorked ) {
            if (pos == null) {
                positionsWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance() {
        return bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }
}
