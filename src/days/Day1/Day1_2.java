package days.Day1;

import utilities.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1_2 {

    // This method turns any number word to a number char
    private static char parseString(String num, boolean first) {
        switch (num) {
            case "one":
                return '1';
            case "two":
                return '2';
            case "three":
                return '3';
            case "four":
                return '4';
            case "five":
                return '5';
            case "six":
                return '6';
            case "seven":
                return '7';
            case "eight":
                return '8';
            case "nine":
                return '9';
            case "oneight":
                return (first) ? '1' : '8';
            case "twone":
                return (first) ? '2' : '1';
            case "threeight":
                return (first) ? '3' : '8';
            case "fiveight":
                return (first) ? '5' : '8';
            case "sevenine":
                return (first) ? '7' : '9';
            case "eightwo":
                return (first) ? '8' : '2';
            case "eighthree":
                return (first) ? '8' : '3';
            case "nineight":
                return (first) ? '9' : '8';
            default:
                return num.charAt(0);
        }
    }

    private static int calibValue(String line) {
        Pattern pattern = Pattern.compile(
                "\\d|oneight|twone|threeight|fiveight|sevenine|eightwo|eighthree|nineight|one|two|three|four|five|six|seven|eight|nine");
        Matcher matcher = pattern.matcher(line);

        int i = 0;
        String first = "", last = "";
        while (matcher.find()) {
            // Checks for first number in the line
            if (i++ == 0) {
                first = matcher.group();
            }
            last = matcher.group();
        }

        String result = parseString(first, true) + "" + parseString(last, false);
        return Integer.parseInt(result);
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
        System.out.println("1.2: " + total);
        input.close();
    }
}
