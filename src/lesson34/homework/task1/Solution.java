package lesson34.homework.task1;

import java.io.*;

public class Solution {

    public void transferFileContent (String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);

        writeToFile(fileToPath, readFromFile(fileFromPath));

        deleteInFile(fileFromPath);


    }

    private StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }

            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

        return res;

    }

    private void writeToFile (String path, StringBuffer contentToWrite){
        try (BufferedReader br = new BufferedReader(new FileReader(path)); BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            if (br.readLine() == null)
                bufferedWriter.append(contentToWrite);
            else {
                bufferedWriter.append("\n");
                bufferedWriter.append(contentToWrite);
            }
        } catch (IOException e){
            System.err.println("Can`t write to file");
        }

    }

    private void deleteInFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append("");
        } catch (IOException e) {
            System.err.println("deleting from file " + path + " failed");
        }
    }


    private void validate (String fileFromPath, String fileToPath) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead()){
            throw  new Exception("File " + fileFrom + " does not have permission to be read");
        }

        if (!fileTo.canWrite()){
            throw  new Exception("File " + fileTo + " does not have permission to be written");
        }

        if (!fileFrom.canWrite()){
            throw  new Exception("File " + fileFrom + " does not have permission to be written");
        }

    }
}
