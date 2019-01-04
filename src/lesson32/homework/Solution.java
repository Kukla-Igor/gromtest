package lesson32.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public int readNumbers() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int n = 3;
        int sum = 0;
        int number;
        String line = "";


        while (n > 0) {
            line = br.readLine();

            if (!validator(line)) {
                n--;
                if (n == 0) {
                    System.out.println("Your numbers are wrong. Number of attempts exceeded");
                    return 0;
                }
                System.out.println("Your numbers are wrong. You have" + n + " attempts to try again");

            } else {
                break;
            }
        }


        String[] stringNumber = line.split(" ");
        for (int i = 0; i < 10; i++) {

            number = Integer.parseInt(stringNumber[i]);
            sum += number;
        }

        return sum;

    }

    private boolean validator(String string) {

        String[] line = string.split(" ");

        if (line.length != 10)
            return false;

        for (int i = 0; i < 10; i++) {
            int m;
            try {
                m = Integer.parseInt(line[i]);
            } catch (Exception e) {
                return false;
            }
            if (m > 100)
                return false;

        }
        return true;

    }
}


