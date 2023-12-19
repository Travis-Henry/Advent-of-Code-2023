package days.Day3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.FileLoader;

public class Day3_2 {

    private static int findAdjacentNums(String prev, String current, String next, ArrayList<Integer> gearCoord) {
        ArrayList<Integer> adjNumbers = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher1 = pattern.matcher(prev);
        Matcher matcher2 = pattern.matcher(current);
        Matcher matcher3 = pattern.matcher(next);
        int gearRatio = 0;

        int start, end;
        for (int gear : gearCoord) { // checks for adj numbers on every gear
            // resets matchers back to the beginning of the line
            matcher1.reset();
            matcher2.reset();
            matcher3.reset();
            while (matcher1.find()) {
                // checks for adj number on prev line
                start = matcher1.start();
                if (start > gear + 1) { // if gear is passed breaks out of loop to save time
                    break;
                }
                end = matcher1.end() - 1;
                if ((start <= gear + 1 && start >= gear - 1) || (end <= gear + 1 && end >= gear - 1)) {
                    adjNumbers.add(Integer.parseInt(matcher1.group()));
                }
            }
            while (matcher2.find()) {
                // checks for adj number on current line
                start = matcher2.start();
                if (start > gear + 1) { // if gear is passed breaks out of loop to save time
                    break;
                }
                end = matcher2.end() - 1;
                if ((start <= gear + 1 && start >= gear - 1) || (end <= gear + 1 && end >= gear - 1)) {
                    adjNumbers.add(Integer.parseInt(matcher2.group()));
                }
            }
            while (matcher3.find()) {
                // checks for adj number on next line
                start = matcher3.start();
                if (start > gear + 1) { // if gear is passed breaks out of loop to save time
                    break;
                }
                end = matcher3.end() - 1;
                if ((start <= gear + 1 && start >= gear - 1) || (end <= gear + 1 && end >= gear - 1)) {
                    adjNumbers.add(Integer.parseInt(matcher3.group()));
                }
            }
            if (adjNumbers.size() == 2) { // mutiplies if there are 2 adj numbers
                gearRatio += (adjNumbers.get(0) * adjNumbers.get(1));
            }
            adjNumbers.clear(); // reset list
        }

        return gearRatio;
    }

    private static ArrayList<Integer> findGears(String line) {
        ArrayList<Integer> gearCoord = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("[*]");
        Matcher matcher = pattern.matcher(line);

        // adds coord of symbols to list
        while (matcher.find()) {
            gearCoord.add(matcher.start());
        }

        return gearCoord;
    }

    public static void start() {

        FileLoader input = new FileLoader("Day3\\input.txt");

        String line = input.getNextLine();
        String prev = "", current = "", next = "";
        int i = 0;
        ArrayList<Integer> currentGears;
        int total = 0;
        while (line != null) {

            if (i == 0) {
                next = line;
            } else if (i == 1) {
                current = next;
                next = line;
            } else {
                prev = current;
                current = next;
                next = line;
                currentGears = findGears(current); // gets the coord of all the gears on current line
                total += findAdjacentNums(prev, current, next, currentGears);
            }

            line = input.getNextLine();
            i++;
        }
        System.out.println(total);
        input.close();
    }
}
