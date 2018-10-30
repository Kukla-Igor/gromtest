package lesson2.HomeWork;

public class SumAndDivision {
    public static void main(String[] args) {
        int i = 0;
        for (int a = 0; a <= 1000; a++) {
            i += a;
        }

        int whole = i / 1234;
        int rem = i % 1234;

        System.out.println(rem > whole);
    }
}
