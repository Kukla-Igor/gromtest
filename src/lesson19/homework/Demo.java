package lesson19.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        File file1 = new File(0, "file1", "txt", 22);
        File file2 = new File(1, "file2", "png", 22);
        File file3 = new File(2, "file3", "jpg", 22);
        File file4 = new File(3, "file4", "avi", 22);
        File file5 = new File(4, "file5", "avi", 1);

        File[] files = {file5, null, null, null};
        File[] files1 = {file1, file2, file4, null};
        String[] formatsSupported = {"txt", "png", "jpg", "avi"};

        Storage storage = new Storage(0, files, formatsSupported, "Ukraine", 200);
        Controller controller = new Controller();

        Storage storage1 = new Storage(1, files1,  formatsSupported, "Ukraine", 30);

       controller.put(storage, file5);
       System.out.println(Arrays.toString(storage.getFiles()));

       //controller.delete(storage, file3);
       //System.out.println(Arrays.toString(storage.getFiles()));

       controller.transferAll(storage, storage1);
        System.out.println(Arrays.toString(storage1.getFiles()));

    }
}
