package Lesson2.HomeWork;

public class SumOfNumbers {
    public static void main(String[] args) {
        long i = 0;
        for (long a = 0; a <= 10000000; a++) {
            i += a;
        }
        System.out.println(i);
    }
}
