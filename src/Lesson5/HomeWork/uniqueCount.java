package Lesson5.HomeWork;


public class uniqueCount {
    public static void main(String[] args) {
        int[] array = {0, 0, 100};
        System.out.println(uniqueCount(array));

    }



    public static  int uniqueCount(int[] array){
        int count = array.length;
        for (int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                if (array[j] == array[i]) {
                   count -= 1;
                   break;
                }
            }
        }
        return count;
    }
}
