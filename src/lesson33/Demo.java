package lesson33;

public class Demo {
    public static void main(String[] args) {
        ReadWriteFile readWriteFile = new ReadWriteFile();

        readWriteFile.readFile("C:/Users/User/Desktop/Test.txt");
        readWriteFile.writeFile("C:/Users/User/Desktop/Test1.txt");
    }

}
