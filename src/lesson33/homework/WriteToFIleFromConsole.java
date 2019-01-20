package lesson33.homework;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class WriteToFIleFromConsole {
    public void writeToFIleFromConsole(String path) {

        FileReader readerFile;
        try {
            readerFile = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }


        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        System.out.println("Enter file content to write in the file:");

        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n");


            while (!br.readLine().equals("wr")) {
                bufferedWriter.append(br.readLine());
                bufferedWriter.append("\n");
            }

        } catch (IOException e1) {
            System.err.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(readerFile);
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }


}

