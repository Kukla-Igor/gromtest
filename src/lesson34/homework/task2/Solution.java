package lesson34.homework.task2;

import java.io.*;

public class Solution {
    public void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);

        String res = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileFromPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                res = res.concat(line);
                res += "\n";
            }
        }




        int count = res.split(".").length;


        String sentence;
        for (int i = 0; i <= count; i++) {

            sentence = isSentences(res, word);
            if (sentence != null) {
                res = res.replaceFirst("." + sentence, "");
                writeToFile(fileToPath, sentence);
            }
        }


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileFromPath, false))) {
            bufferedWriter.append(res);
        }
    }

    private void writeToFile(String path, String contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can`t write to file");
        }

    }

    private String isSentences(String text, String word) {
        String sentence;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.') {
                for (int j = i + 1; j < text.length(); j++) {
                    if (text.charAt(j) == '.') {
                        sentence = text.substring(i + 1, j);
                        if (sentence.contains(word) && sentence.length() > 10) {
                            return sentence;
                        }
                        break;
                    }
                }
            }

        }
        return null;
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
