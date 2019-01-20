package lesson34.homework.task3;


import org.apache.commons.io.IOUtils;

import java.io.*;


public class Solution {
    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);


        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        try (BufferedReader br = new BufferedReader(new FileReader(fileFrom)); BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTo))) {
            String line;
            while ((line = br.readLine()) != null) {
                bufferedWriter.write(line);
            }
        }

        }


    public void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);


        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        try (BufferedReader br = new BufferedReader(new FileReader(fileFrom)); BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTo))) {


            IOUtils.copy(br, bufferedWriter);
        }


    }

    private void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permission to be read");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " does not have permission to be written");
        }

        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileFrom + " does not have permission to be written");
        }

    }
}
