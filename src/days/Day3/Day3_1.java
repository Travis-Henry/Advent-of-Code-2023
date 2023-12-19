package days.Day3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilities.FileLoader;

public class Day3_1 {

    // Sum a list
    private static int sumList(ArrayList<Integer> nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        return sum;
    }

    private static ArrayList<Integer> findAdjacentNums(String line, ArrayList<Integer> symbolCoord) {
        ArrayList<Integer> adjNumbers = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);

        int start, end;
        while (matcher.find()) {
            start = matcher.start();
            end = (matcher.end() - 1);
            for (int i = 0; i < symbolCoord.size(); i++) {
                int coord = symbolCoord.get(i);
                // checks left and right of symbol position
                if ((start <= coord + 1 && start >= coord - 1) || (end <= coord + 1 && end >= coord - 1)) {
                    adjNumbers.add(Integer.parseInt(matcher.group()));
                }
            }
        }
        return adjNumbers;
    }

    private static ArrayList<Integer> findSymbols(String line) {
        ArrayList<Integer> symbolCoord = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("[!@#$%^&*_+/?=-]");
        Matcher matcher = pattern.matcher(line);

        // adds coord of symbols to list
        while (matcher.find()) {
            symbolCoord.add(matcher.start());
        }

        return symbolCoord;
    }

    public static void start() {

        FileLoader input = new FileLoader("Day3\\input.txt");

        String line = input.getNextLine();
        String prev = "", current = "", next = "";
        int i = 0;
        ArrayList<Integer> currentSymbols;
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
                currentSymbols = findSymbols(current);
                total += sumList(findAdjacentNums(prev, currentSymbols));
                total += sumList(findAdjacentNums(current, currentSymbols));
                total += sumList(findAdjacentNums(next, currentSymbols));
            }

            line = input.getNextLine();
            i++;
        }
        System.out.println(total);
        input.close();
    }
}
