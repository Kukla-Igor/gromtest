package lesson5.HomeWork;



public class ArraySort {



    public static  int[] sortAscending(int[] array){
        int value;
        for (int i = 0; i < array.length; i++){
            for (int j = i; j < array.length; j++){
                if (array[j] > array[i]) {
                    value = array[j];
                    array[j] = array[i];
                    array [i] = value;
                }
            }
        }
        return array;
    }



    public static  int[] sortDescending(int[] array){
        int value;
        for (int i = 0; i < array.length; i++){
            for (int j = i; j < array.length; j++){
                if (array[j] < array[i]) {
                    value = array[j];
                    array[j] = array[i];
                    array [i] = value;
                }
            }
        }
        return array;
    }

}
