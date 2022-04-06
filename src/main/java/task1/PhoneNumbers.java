package task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringJoiner;

public class PhoneNumbers {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("src/main/resources/file.txt");

        StringBuilder numbersFromFile = new StringBuilder();

        int i;

        while ((i = fileInputStream.read()) != -1) {
            numbersFromFile.append((char) i);

        }
        fileInputStream.close();

        String numbersFromFileToString = numbersFromFile.toString();
        String[] separateStrings = numbersFromFileToString.split("\n");

        StringJoiner result = new StringJoiner("\n");

        for (String s : separateStrings) {

            char[] stringToChars = s.toCharArray();

            if (stringToChars[3] != ' ') {
                result.add(s);
            }
        }
        System.out.println(result);
    }
}

