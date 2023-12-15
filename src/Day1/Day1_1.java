package Day1;

import java.io.*;
import java.util.ArrayList;

public class Day1_1 {
    public static int calibValue(String line) {
        // Number list to keep track of digits
        ArrayList<Character> numbers = new ArrayList<Character>();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                numbers.add(line.charAt(i));
            }
        }

        // Adds the first number and last number of the number list
        return Integer.parseInt(numbers.get(0) + "" + numbers.get(numbers.size() - 1));
    }

    public static void start() {

        // Get file
        File file = new File("src\\Day1\\input1.txt");
        if (!file.exists()) {
            System.out.println("The file does not exist");
        }
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));

            // Read the file line by line
            String line = input.readLine();
            int total = 0;
            while (line != null) {
                total += calibValue(line);

                line = input.readLine();
            }
            System.out.println(total);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}