package lesson3;

public class IfElseExample {
    public static void main(String[] args) {
        int test = 1000;

        if (test > 100) {
            System.out.println("Good");
            System.out.println("...");
        } else {
            System.out.println("Bad");
            System.out.println("...");
        }


        boolean result = false;
        if (test > 1000)
            result = true;

        if (result)
            System.out.println("Nice");
        else
            System.out.println("Not nice");

        if (result && test > 100 || test > 500)
            System.out.println("!");
        else
            System.out.println("?");

        if (!(test > 0))
            System.out.println("!!!!!!");

    }

}
