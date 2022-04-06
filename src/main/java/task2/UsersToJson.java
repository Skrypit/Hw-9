package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class UsersToJson {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("src/main/resources/file2.txt");

        BufferedReader usersFromFile = new BufferedReader(fileReader);
        String str;
        List<User> users = new ArrayList<>();

        while ((str = usersFromFile.readLine()) != null) {
            String[] separateStrings = str.split("\n");

            for (String s : separateStrings) {

                String[] split = s.split(" ");

                if (split[1].matches("[0-9]+")) {
                    String name = split[0];
                    int age = Integer.parseInt(split[1]);

                    User user = new User(name, age);
                    users.add(user);
                }
            }
        }
        fileReader.close();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(users);

        try (Writer fileWriter = new FileWriter("src/main/resources/user.json")) {
            fileWriter.write(String.valueOf(json));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}