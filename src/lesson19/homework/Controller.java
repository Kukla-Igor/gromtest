package lesson19.homework;

import java.awt.image.RasterFormatException;

public class Controller {

    public static File put(Storage storage, File file) throws Exception {
        nullCheck(file);
        formatCheck(storage, file);
        sizeCheck(storage, file);
        idCheck(storage, file);
        nullCheck(storage);

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                break;
            }
        }
        return file;
    }

    public static File delete(Storage storage, File file) throws Exception {
        nullCheck(file);
        for (int i = 0; i < storage.getFiles().length; i++){
            if (file.equals(storage.getFiles()[i])) {
                storage.getFiles()[i] = null;
                return file;
            }
        }
        throw new Exception("файл" + file.getId() + " не найден в хранилище " + storage.getId());

    }



    private static void formatCheck(Storage storage, File file) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (file.getFormat().equals(format)) {
                return;
            }
        }
        throw new Exception("Формат файла" + file.getId() + " не поддерживаеться хранилищем " + storage.getId());
    }

    private static void sizeCheck(Storage storage, File file) throws Exception {
        long size = file.getSize();
        for (File storageFile : storage.getFiles()) {
            if (storageFile != null) {
                size += storageFile.getSize();
            }
        }
        if (size > storage.getStorageSize())
            throw new Exception("файл" + file.getId() + " не поместиться в хранилище " + storage.getId());
    }

    private static void idCheck(Storage storage, File file) throws Exception {
        for (File storageFile : storage.getFiles()) {
            if (storageFile != null) {
                if (storageFile.getId() == file.getId())
                    throw new Exception("файл " + file.getId() + " уже есть в хранилище " + storage.getId());
            }
        }
    }

    private static void nullCheck(Storage storage) throws Exception {
        for (File storageFile : storage.getFiles()) {
            if (storageFile == null) {
                return;

            }
        }
        throw new Exception("В хранилище " + storage.getId() + " нет свободных ячеек");
    }

    private static void nullCheck(File file) throws Exception {

        if (file == null) {
            throw new Exception("Файл не задан");
        }

    }

}




