package lesson16;
//
import java.util.Arrays;
//
public class StringMethods {
    public static void main(String[] args) {
        String test = "someStringExample";

        System.out.println(test.isEmpty());
        System.out.println("".isEmpty());

        System.out.println(test.length());

        System.out.println(test.charAt(2));

        String res = test.replace("me", "T");

        System.out.println(res);

        System.out.println(test.replaceAll("me", "T"));
        System.out.println(test);


 System.out.println(test.contains("meS"));

        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));

        System.out.println(" test ".trim());
        test.intern();
        test.substring(1);
        test.toLowerCase();
        test.toLowerCase();


        test.getBytes();
        test.equals("eeee");

    }
}
