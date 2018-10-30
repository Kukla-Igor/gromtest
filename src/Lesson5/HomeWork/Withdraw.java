package Lesson5.HomeWork;

public class Withdraw {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(withdraw(names, balances, "Ann", 505));
    }



    public static int withdraw(String[] clients, int[] balances, String client, int amount){
        int clietnIndex = 0;

        for (String cl : clients){
            if (cl == client)
                break;
            clietnIndex++;
        }

        return (long) balances[clietnIndex] - amount < 0 ? -1 : balances[clietnIndex] - amount;
    }
}
