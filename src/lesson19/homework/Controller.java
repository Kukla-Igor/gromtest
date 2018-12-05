package lesson19.homework;

import java.awt.image.RasterFormatException;

public class Controller {

    public static File put(Storage storage, File file) throws Exception {
        nullCheck(file);
        formatCheck(storage, file);
        File[] files = {file};
        sizeCheck(storage, files);
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
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (file.equals(storage.getFiles()[i])) {
                storage.getFiles()[i] = null;
                return file;
            }
        }
        throw new Exception("файл" + file.getId() + " не найден в хранилище " + storage.getId());

    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        for (File file : storageFrom.getFiles()) {
            idCheck(storageTo, file);
        }

        sizeCheck(storageTo, storageFrom.getFiles());

        for (int i = 0; i < storageFrom.getFormatsSupported().length; i++) {
            for (int j = 0; j < storageTo.getFormatsSupported().length; j++) {
                if (storageFrom.getFormatsSupported()[i].equals(storageTo.getFormatsSupported()[j])) {
                    break;
                }
            }
        }
        throw new Exception("Формат файлов из хранилища" + storageFrom.getId() + " не поддерживаеться хранилищем " + storageTo.getId());



    }


    private static void formatCheck(Storage storage, File file) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (file.getFormat().equals(format)) {
                return;
            }
        }
        throw new Exception("Формат файла" + file.getId() + " не поддерживаеться хранилищем " + storage.getId());
    }

    private static void sizeCheck(Storage storage, File[] files) throws Exception {

        long size = 0;
        for(File file : files){
            size += file.getSize();
        }
        for (File storageFile : storage.getFiles()) {
            if (storageFile != null) {
                size += storageFile.getSize();
            }
        }
        if (size > storage.getStorageSize())
            throw new Exception("не достаточно места в хранилище " + storage.getId());
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




