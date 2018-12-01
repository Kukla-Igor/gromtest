package lesson17.homework.task1;

public class Solution {
    public static void main(String[] args) {
        String string = "jj 55 kk !! LL pp";

        System.out.println(countWords(string));
    }

    public static int countWords (String input){
        if (!input.isEmpty()){
            int length = 0;
            length = input.split(" ").length;
            int counter = length;
            String[] array = new String[length];
            array = input.split(" ");
            for (int i = 0; i < length; i++){
               if (!isWord(array[i]))
                   counter--;
            }
            return counter;
        }
        return 0;
    }

    public static boolean isWord(String word){
        // bytes = new byte[word.split("").length];
        byte[] bytes = word.getBytes();
        for (int i = 0; i < bytes.length; i++){
            if ((bytes[i] >= 65 && bytes[i] <= 90) || (bytes[i] >= 97 && bytes[i] <= 122) )
                return true;
        }
        return false;
    }
}