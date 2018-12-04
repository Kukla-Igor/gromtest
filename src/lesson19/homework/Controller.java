package lesson19.homework;

import java.awt.image.RasterFormatException;

public class Controller {

    public void put(Storage storage, File file) {
        if (file == null)
            return;

        for(int i = 0; i< storage.getFiles().length; i++){
            if (storage.getFiles()[i] == null)
                return;
        }

        checkAndAdd(storage, file);
    }


    public void delete(Storage storage, File file) {
        try {
            equalsCheck(storage, file);
            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i].equals(file) && storage.getFiles()[i].hashCode() == file.hashCode() && storage.getFiles()[i].getName() == file.getName()) {
                    storage.getFiles()[i] = null;
                    return;
                }
            }
        } catch (Exception e) {
            System.err.println("Файл " + file.getId() + " не может быть удален из хранилища " + storage.getId());
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {

        try {

        } catch (Exception e) {
            System.err.println("формат " + storageTo.getId() + " не поддерживаються хранилищем " + storageFrom.getId());
            return;
        }

        try {
            for (int i = 0; i < storageFrom.getFiles().length; i++) {
                idCheck(storageTo, storageFrom.getFiles()[i]);
            }
        } catch (Exception e) {
            System.err.println("В хранилище " + storageFrom.getId() + " уже есть файлы из " + storageTo.getId());
            return;
        }

        try {
            for (int i = 0; i < storageFrom.getFiles().length; i++) {
                sizeCheck(storageTo, storageFrom.getFiles());
            }
        } catch (Exception e) {
            System.err.println("В хранилище " + storageFrom.getId() + " не поместяться файлы из " + storageTo.getId());
            return;
        }

        try {

            for (int i = 0; i < storageFrom.getFiles().length; i++) {
                nullCheck(storageTo);
                storageTo.getFiles()[i] = storageFrom.getFiles()[i];
            }
        } catch (Exception e) {
            System.err.println("В хранилище " + storageFrom.getId() + " нет свободныъ ячеек для файлов с id из " + storageTo.getId());
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        File file;
        for (int i = 0; i < storageFrom.getFiles().length; i++) {

            if (storageFrom.getFiles()[i].getId() == id) {
                file = storageFrom.getFiles()[i];
                checkAndAdd(storageTo, file);
                return;
            } else
                throw new Exception("файла " + id + "не найдено");
        }
    }


    private void formatsCheck(Storage storage, File file) throws Exception {

        for (int i = 0; i < storage.getFormatsSupported().length; i++) {
            if (file.getFormat().equals(storage.getFormatsSupported()[i])) {
                return;
            }
        }
        throw new Exception("Format check error");
    }
        private void formatsCheckStorage(Storage storageFrom, Storage storageTo) throws Exception {

            for (int i = 0; i < storageFrom.getFormatsSupported().length; i++) {
                for (int j = 0; j < storageTo.getFormatsSupported().length; i++) {
                    if (storageFrom.getFormatsSupported()[i].equals(storageTo.getFormatsSupported()[j])) {
                        return;
                    }
                }
                throw new Exception("Format check error");
            }
    }

    private void idCheck(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (file.equals(storage.getFiles()[i])) {
                throw new Exception("Id check error");
            }
        }
    }


    private void sizeCheck(Storage storage, File[] files) throws Exception {
        long size = 0;
        for (int i = 0; i < files.length; i++) {
            size += files[i].getSize();
        }
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null) {
                size += storage.getFiles()[i].getSize();
            }
        }
        if (storage.getStorageSize() < size) {
            throw new Exception("size check error");
        }
    }

    private void nullCheck(Storage storage) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                return;
            }
        }
        throw new Exception("Null check error");
    }

    private void equalsCheck(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i].equals(file) && storage.getFiles()[i].hashCode() == file.hashCode()) {
                storage.getFiles()[i] = null;
                return;
            }
        }
        throw new Exception("Null check error");
    }

    private void checkAndAdd(Storage storage, File file) {
        try {
            formatsCheck(storage, file);
        } catch (Exception e) {
            System.err.println("Файл " + file.getId() + " формата " + file.getFormat() + " не может быть добавлен в хранилище " + storage.getId());
            return;
        }

        try {
            idCheck(storage, file);
        } catch (Exception e) {
            System.err.println("Файл " + file.getId() + " не может быть добавлен в хранилище " + storage.getId());
            return;
        }


        try {
            File[] files = {file};
            sizeCheck(storage, files);
        } catch (Exception e) {
            System.err.println("Файл " + file.getId() + " превышает размер " + storage.getId());
            return;
        }

        try {
            nullCheck(storage);
        } catch (Exception e) {
            System.err.println("Файл " + file.getId() + " не может быть добавлен в заполненое хранилище " + storage.getId());
            return;
        }


        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                return;
            }

        }


    }


}
