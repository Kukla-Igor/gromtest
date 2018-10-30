package Lesson4.HomeWork;

public class FindDivCount {



    public static int findDivCount(short a, short b, int n) {
        int count = 0;
        for (short i = a; i <= b; i++) {
            if (i % n == 0)
                count++;
        }
        return count;
    }
}
