package lesson29;

public class File {
    private String fileName;
    private long sizeInButes;

    public File(String fileName, long sizeInButes) {
        this.fileName = fileName;
        this.sizeInButes = sizeInButes;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        return fileName.equals(file.fileName);
    }

    @Override
    public int hashCode() {
        return fileName.hashCode();
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", sizeInButes=" + sizeInButes +
                '}';
    }
}
