package lesson8.Homework;

public class Arithmetic {

    static int maxElement(int[] array) {
        int max = array[0];

        for (int el: array ) {
            if (el > max)
                max = el;
        }
        return max;
    }

    static int minElement(int[] array) {
        int min = array[0];

        for (int el: array ) {
            if (el < min)
                min = el;
        }
        return min;
    }

   static public boolean check (int[] array) {
        return maxElement(array) + minElement(array) > 100;
    }
}
