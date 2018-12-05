package lesson19.homework;

import java.awt.image.RasterFormatException;

public class Controller {

    public static void put(Storage storage, File file) {

        if (file == null) {
            return;
        }

        try {
            formatCheck(storage, file);
        } catch (Exception e) {
            System.out.println("формат файла " + file.getId() + " не поддерживаеться хранилищем " + storage.getId());
            return;
        }

        try {
            sizeCheck(storage, file);
        } catch (Exception e) {
            System.out.println("размер файла " + file.getId() + " не помещаеться в хранилище " + storage.getId());
            return;
        }

        try {
            idCheck(storage, file);
        } catch (Exception e) {
            System.out.println("файл " + file.getId() + " уже есть в хранилище " + storage.getId());
            return;
        }

        try {
            nullCheck(storage, file);
        } catch (Exception e) {
            System.out.println("для файла " + file.getId() + " нет свободных ячеек в хранилище " + storage.getId());
            return;
        }


        for (int i = 0; i < storage.getFiles().length; i++){
            if (storage.getFiles()[i] == null)
                storage.getFiles()[i] = file;
        }



    }

    private static void formatCheck(Storage storage, File file) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (file.getFormat().equals(format)) {
                return;
            }
        }
        throw new Exception("Format check error");
    }

    private static void sizeCheck(Storage storage, File file) throws Exception {
        long size = file.getSize();
        for (File storageFile : storage.getFiles()) {
            if (storageFile != null) {
                size += storageFile.getSize();
            }
        }
        if (size > storage.getStorageSize())
            throw new Exception("Size check error");
    }

    private static void idCheck(Storage storage, File file) throws Exception {
        for (File storageFile : storage.getFiles()) {
            if (storageFile != null) {
                if (storageFile.getId() == file.getId())
                    throw new Exception("Size check error");
            }
        }
    }

    private static void nullCheck(Storage storage, File file) throws Exception {
        for (File storageFile : storage.getFiles()) {
            if (storageFile == null) {
                return;

            }
        }
        throw new Exception("Size check error");
    }


}


