package lesson19.homework;

import java.awt.image.RasterFormatException;

public class Controller {

    public void put(Storage storage, File file) {

        try {
            formatsCheck(storage, file);
        } catch (RuntimeException e) {
            System.err.println("Файл " + file.getId() + " формата " + file.getFormat() + " не может быть добавлен в хранилище " + storage.getId());
            return;
        }

        try {
            idCheck(storage, file);
        } catch (RuntimeException e) {
            System.err.println("Файл " + file.getId() + " не может быть добавлен в хранилище " + storage.getId());
            return;
        }


        try {
            sizeCheck(storage, file);
        } catch (RuntimeException e) {
            System.err.println("Файл " + file.getId() + " превышает размер " + storage.getId());
            return;
        }

        try {
            nullCheck(storage);
        } catch (RuntimeException e) {
            System.err.println("Файл " + file.getId() + " не может быть добавлен в заполненое хранилище " + storage.getId());
            return;
        }


        for (int i = 0; i < storage.getFiles().length; i++) {
            storage.getFiles()[i] = file;
        }

    }


    public void delete(Storage storage, File file) {
        try {
            equalsCheck(storage, file);
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i].equals(file) && storage.getFiles()[i].hashCode() == file.hashCode()) {
                    storage.getFiles()[i] = null;
                }
            }
        } catch (NullPointerException e) {
            System.err.println("Файл " + file.getId() + " не может быть удален из хранилища " + storage.getId());
        }
    }


    private void formatsCheck(Storage storage, File file) throws RuntimeException {

        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (file.getFormat().equals(storage.getFormatsSupported()[i])) {
                return;
            }
        }
        throw new RuntimeException("Format check error");
    }

    private void idCheck(Storage storage, File file) throws RuntimeException {
        for (int i = 0; i < storage.getFiles().length; i++) {

            if (file.getId() == storage.getFiles()[i].getId()) {
                throw new RuntimeException("Id check error");
            }
        }
    }

    private void sizeCheck(Storage storage, File file) throws RuntimeException {
        long size = file.getSize();
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null) {
                size += storage.getFiles()[i].getSize();
            }
        }
        if (storage.getStorageSize() < size) {
            throw new RuntimeException("size check error");
        }
    }

    private void nullCheck(Storage storage) throws NullPointerException {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                return;
            }
        }
        throw new NullPointerException("Null check error");
    }

    private void equalsCheck(Storage storage, File file) throws NullPointerException {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i].equals(file) && storage.getFiles()[i].hashCode() == file.hashCode()) {
                storage.getFiles()[i] = null;
                return;
            }
        }
        throw new NullPointerException("Null check error");
    }


}
