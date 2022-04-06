package task3;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordsCounter {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/words.txt");
        Scanner scanner = new Scanner(file);

        Map<String, Integer> map = new LinkedHashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            int count;
            if (map.containsKey(word)) {
                count = map.get(word) + 1;
            } else {
                count = 1;
            }
            map.put(word, count);
        }
        scanner.close();

        int maxFrequency = (int) map.values().toArray()[0];
        for (int i = 0; i < map.size(); i++) {
            if ((int) map.values().toArray()[i] > maxFrequency) {
                maxFrequency = (int) map.values().toArray()[i];
            }
        }
        for (int i = maxFrequency; i > 0; i--) {
            for (int j = 0; j < map.size(); j++) {
                if ((int) map.values().toArray()[j] == i) {
                    System.out.println(map.keySet().toArray()[j] + " " + i);
                }
            }
        }
    }
}

