package lesson19.homework;

import java.awt.image.RasterFormatException;

public class Controller {

    public void put(Storage storage, File file) {

        try {
            formatsCheck(storage, file);
        } catch (RuntimeException e) {
            System.err.println("Файл " + file.id + " формата " + file.format + " не может быть добавлен в хранилище " + storage.id);
            return;
        }

        try {
            idCheck(storage, file);
        } catch (RuntimeException e) {
            System.err.println("Файл " + file.id + " не может быть добавлен в хранилище " + storage.id);
            return;
        }


        try {
            sizeCheck(storage, file);
        } catch (RuntimeException e) {
            System.err.println("Файл " + file.id + " превышает размер " + storage.id);
            return;
        }

        try {
            nullCheck(storage);
        } catch (RuntimeException e) {
            System.err.println("Файл " + file.id + " не может быть добавлен в заполненое хранилище " + storage.id);
            return;
        }


        for (int i = 0; i < storage.files.length; i++) {
            storage.files[i] = file;
        }

    }


    public void delete(Storage storage, File file) {
        try {
            equalsCheck(storage, file);
            for (int i = 0; i < storage.files.length; i++) {
                if (storage.files[i].equals(file) && storage.files[i].hashCode() == file.hashCode()) {
                    storage.files[i] = null;
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Файл " + file.id + " не может быть удален из хранилища " + storage.id);
        }
    }


    private void formatsCheck(Storage storage, File file) throws RuntimeException {

        for (int i = 0; i < storage.formatsSupported.length; i++) {
            if (file.format.equals(storage.formatsSupported[i])) {
                return;
            }
        }
        throw new RuntimeException("Format check error");
    }

    private void idCheck(Storage storage, File file) throws RuntimeException {
        for (int i = 0; i < storage.files.length; i++) {

            if (file.id == storage.files[i].id) {
                throw new RuntimeException("Id check error");
            }
        }
    }

    private void sizeCheck(Storage storage, File file) throws RuntimeException {
        long size = file.size;
        for (int i = 0; i < storage.files.length; i++) {
            if (storage.files[i] != null) {
                size += storage.files[i].size;
            }
        }
        if (storage.storageSize < size) {
            throw new RuntimeException("size check error");
        }
    }

    private void nullCheck(Storage storage) throws NullPointerException {
        for (int i = 0; i < storage.files.length; i++) {
            if (storage.files[i] == null) {
                return;
            }
        }
        throw new NullPointerException("Null check error");
    }

    private void equalsCheck(Storage storage, File file) throws NullPointerException {
        for (int i = 0; i < storage.files.length; i++) {
            if (storage.files[i].equals(file) && storage.files[i].hashCode() == file.hashCode()) {
                storage.files[i] = null;
                return;
            }
        }
        throw new NullPointerException("Null check error");
    }


}
