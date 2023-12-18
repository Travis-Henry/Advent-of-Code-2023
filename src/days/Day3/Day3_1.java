package days.Day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import utilities.FileLoader;

public class Day3_1 {

    public static void start() {

        File file = new File("src\\Day3\\input.txt");
        if (!file.exists()) {
            System.out.println("The file does not exist");
        }
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));

            String line = input.readLine();
            while (line != null) {
                System.out.println(line);

                line = input.readLine();
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
