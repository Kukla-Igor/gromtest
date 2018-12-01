package lesson17.homework.task3;

public class Solution {
    public static void main(String[] args) {
        System.out.println(mostCountedWord("Hey hey hey are are are are you you are n are"));
        System.out.println(mostCountedWord(".. 54 jlji l jlji l l jlji "));

    }

    public static String mostCountedWord (String input){
        String[] strings = input.split(" ");
        String word = null;
        int bigCount = 0;
        int smallCount;

        for (int i = 0; i < strings.length; i++){
            smallCount = 0;
            for (int j = i; j < strings.length; j++){
                if (isWord(strings[i]) && isWord(strings[j])) {
                    if (strings[j].equals(strings[i])) {
                        smallCount++;
                        if (smallCount > bigCount) {
                            bigCount = smallCount;
                            word = strings[i];
                        }
                    }
                }
            }
        }
        return word;
    }

    public static boolean isWord(String word){
        byte[] bytes = word.getBytes();
        for (int i = 0; i < bytes.length; i++){
            if (Character.isLetter(bytes[i])) {
                return true;
            }
        }
        return false;
    }

}
