package lesson17.homework.task2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxWord("Test words for t5555555555555555555kkk khjk?kjphhhhhhhh this method!"));
       System.out.println(maxWord(""));
        System.out.println(minWord(" words fr. 5y th method!"));
        System.out.println(minWord(""));

    }

    public static String maxWord(String input){

        String[] strings = input.split(" ");
        String maxWord = null;
        int length = 0;
        for (int i = 0; i < strings.length; i++){
            if (isWordForMin(strings[i])) {
                 if (strings[i].length() > length) {
                    length = strings[i].length();
                    maxWord = strings[i];
                }
            }
        }
        return maxWord;

    }

    public static String minWord (String input){
        String[] strings = input.split(" ");
        String minWord = null;
        int length = 2147483647;
        for (int i = 0; i < strings.length; i++){
            if (isWordForMin(strings[i])) {
                if (strings[i].length() < length) {
                    length = strings[i].length();
                    minWord = strings[i];
                }
            }
        }
        return minWord;

    }


    public static boolean isWordForMin(String word){
        byte[] bytes = word.getBytes();
        for (int i = 0; i < bytes.length; i++){
            if (Character.isLetter(bytes[i])) {
                return true;
            }
        }
        return false;
    }


}


