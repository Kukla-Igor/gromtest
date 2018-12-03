package lesson19.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        File file1 = new File(0, "file1", "txt", 22);
        File file2 = new File(1, "file2", "png", 22);
        File file3 = new File(2, "file3", "jpg", 22);
        File file4 = new File(3, "file4", "avi", 22);
        File file5 = new File(1, "file5", "avi", 1);

        File[] files = {null, file2, file3, file1};
        String[] formatsSupported = {"txt", "png", "jpg", "avi"};

        Storage storage = new Storage(0, files, formatsSupported, "Ukraine", 200);
        Controller controller = new Controller();

        controller.put(storage, file2);
        System.out.println(Arrays.toString(storage.files));

      //  controller.delete(storage, file5);
        //System.out.println(Arrays.toString(storage.files));

    }
}
