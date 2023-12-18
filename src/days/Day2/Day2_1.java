package days.Day2;

import utilities.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2_1 {

    private static boolean possible(int red, int green, int blue, HashMap<String, Integer> cubes) {
        return (cubes.get("red") <= red && cubes.get("green") <= green && cubes.get("blue") <= blue);
    }

    private static void populateMap(String line, HashMap<String, Integer> cubes) {
        Pattern pattern = Pattern.compile("((\\d+) (\\w+))");
        Matcher matcher = pattern.matcher(line);

        String color;
        int value;
        while (matcher.find()) {

            color = matcher.group(3);
            value = Integer.parseInt(matcher.group(2));
            if (cubes.containsKey(color)) {
                // compares which number is bigger
                cubes.put(color, Integer.max(value, cubes.get(color)));
            } else {
                // if key does not exist add the value to the map
                cubes.put(color, value);
            }
        }
    }

    public static void start() {
        FileLoader input = new FileLoader("Day2\\input.txt");

        // loop reads one line at a time
        String line = input.getNextLine();
        int i = 1; // keeps track of game number
        int total = 0;
        HashMap<String, Integer> cubes = new HashMap<String, Integer>();
        while (line != null) {

            populateMap(line, cubes);
            total += (possible(12, 13, 14, cubes)) ? i : 0;

            line = input.getNextLine();
            i++;
            cubes.clear(); // reset cube map for next line
        }
        System.out.println(total);
        input.close();
    }
}
