package days.Day1;

import java.util.ArrayList;
import utilities.*;

public class Day1_1 {

    private static int calibValue(String line) {
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
        FileLoader input = new FileLoader("Day1\\input1.txt");

        // Read the file line by line
        String line = input.getNextLine();
        int total = 0;
        while (line != null) {
            total += calibValue(line);

            line = input.getNextLine();
        }
        System.out.println("1.1: " + total);
        input.close();
    }
}