package lesson29;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetIntro {
    public static void main(String[] args) {

        Set<String> set = new LinkedHashSet<>();
        set.add("testStr");
        set.add("111");
        set.add("aaa");
        set.add("bbb");
        System.out.println(set);
        set.add("aaa");


        Set<File> files = new HashSet<>();
        File file1 =  new File("pict.txt", 100);
        File file2 =  new File("home.txt", 178);
        File file3 =  new File("home.txt", 340);

        files.add(file1);
        files.add(file2);
        files.add(file3);

        System.out.println(files);


    }
}
