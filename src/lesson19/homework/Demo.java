package lesson19.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        File file1 = new File(0, "file1", "txt", 22);
        File file2 = new File(1, "file2", "png", 22);
        File file3 = new File(2, "file3", "jpg", 22);
        File file4 = new File(3, "file4", "avi", 2);
        File file5 = new File(4, "file5", "avi", 1);

       File[] filesFrom = {file1, file2, file3, file4};
       File[] filesTo = {file5, null, null, null};

       String[] formatSupportedFrom = {"txt", "png", "jpg", "avi"};
       String[] formatSupportedTo = {"txt", "png", "jpg", "avi"};

       Controller controller = new Controller();
        Storage storageFrom = new Storage(0, filesFrom, formatSupportedFrom, "Ukraine", 200);
        Storage storageTo = new Storage(1, filesTo, formatSupportedTo, "Ukraine", 200);

        try {
            controller.transferAll(storageFrom, storageTo);
            System.out.println(Arrays.toString(storageFrom.getFiles()));
            System.out.println(Arrays.toString(storageTo.getFiles()));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }






    }
}
