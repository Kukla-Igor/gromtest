package lesson18.homework.task2;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumbers("1 2 kshdfkjshg    3 4 5 6 kshd")));
    }

    private static int[] findNumbers(String text) {
        String[] words = text.split(" ");
        int[] numbers = new int[words.length];
        int count = words.length;
        int i = 0;//
        for (String word : words) {
            if(numbers[i] == Integer.parseInt(word))
                i++;
             else
                System.out.println("not a number");
                count--;

        }
        if (count == words.length)
            return numbers;

        int[] res = new int[count];
        for (int j = 0; j < count; j++) {
            res[j] = numbers[j];
        }

        return res;


    }
}
