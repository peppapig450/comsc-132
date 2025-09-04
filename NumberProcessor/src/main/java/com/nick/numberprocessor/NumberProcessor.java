package com.nick.numberprocessor;

import java.util.Scanner;

public class NumberProcessor {
    public static int getArraySize(Scanner scanner) {
        System.out.print("How many numbers would you like to enter: ");

        int arraySize = scanner.nextInt();

        // Prompt the user for the size until they enter a valid size
        while (arraySize < 1) {
            System.out.println("Error. Entered size must be positive. Try again.");

            System.out.print("How many numbers would you like to enter: ");
            arraySize = scanner.nextInt();
        }

        return arraySize;
    }

    public static void fillArray(double[] userArray, Scanner scanner) {
        for (int i = 0; i < userArray.length; ++i) {
            System.out.printf("Enter number %d: ", i + 1);
            userArray[i] = scanner.nextDouble();
        }
    }

    public static void displayStatistics(double biggest, double smallest, double sum, double average) {
        System.out.println("The biggest number is " + biggest + ".");
        System.out.println("The smallest number is " + smallest + ".");

        System.out.printf("The sum of numbers is %.2f.\n", sum);
        System.out.printf("The average of the numbers is %.2f.\n", average);
    }

    public static void calculateAndDisplayStats(double[] userArray) {
        double biggest = userArray[0];
        double smallest = userArray[0];
        double sum = userArray[0];

        for (int i = 1; i < userArray.length; ++i) {
            double currentValue = userArray[i];

            if (currentValue > biggest) {
                biggest = currentValue;
            }

            if (currentValue < smallest) {
                smallest = currentValue;
            }

            sum += currentValue;
        }

        double average = sum / userArray.length;

        displayStatistics(biggest, smallest, sum, average);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = getArraySize(scanner);

        double[] userInput = new double[arraySize];
        fillArray(userInput, scanner);

        for (double num : userInput) {
            System.out.print(num + " ");
        }
        System.out.println();

        calculateAndDisplayStats(userInput);
    }
}
