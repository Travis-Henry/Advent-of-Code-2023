import days.Day1.*;
import days.Day2.*;
import days.Day3.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to my Advent of Code solutions!");

        String choice;
        do {

            System.out.print(
                    "\nPlease enter a number for the day to run that solution: ");
            choice = scnr.nextLine();

            switch (choice) {
                case "1":
                    Day1_1.start();
                    Day1_2.start();
                    break;
                case "2":
                    Day2_1.start();
                    Day2_2.start();
                    break;
                case "3":
                    Day3_1.start();
                    break;
                case "-1":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please try again, enter -1 to leave");
                    break;
            }

        } while (!choice.equals("-1"));
        scnr.close();
    }
}
