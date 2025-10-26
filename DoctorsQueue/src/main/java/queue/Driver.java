package queue;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice = "";

        String[][] menu = {
                { "1.", "General" },
                { "2.", "Exam" },
                { "3.", "Priority" },
                { "4.", "Test Results" },
                { "Q.", "Quit" },
        };

        String[] queueNames = { "General", "Exam", "Priority", "Test Results" };
        MyQueue[] queues = new MyQueue[queueNames.length];

        for (int i = 0; i < queueNames.length; ++i) {
            queues[i] = new MyQueue();
        }

        System.out.println("Choose the reason for your visit:");
        for (String[] menuItem : menu) {
            System.out.printf("  %-3s %s%n", menuItem[0], menuItem[1]);
        }

        while (!userChoice.equalsIgnoreCase("q")) {
            System.out.print("Enter your choice: [1234Q]: ");
            userChoice = input.nextLine();

            if (userChoice.equalsIgnoreCase("q")) {
                System.out.println("Numbers in the queues:");
                for (int i = 0; i < queueNames.length; ++i) {
                    System.out.print(queueNames[i] + ": ");
                    while (!queues[i].isEmpty()) {
                        try {
                            System.out.print(queues[i].peek() + " ");
                            queues[i].dequeue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println();
                }
            } else {
                Integer choiceNumber = Integer.parseInt(userChoice);
                if (choiceNumber >= 1 && choiceNumber <= 4) {
                    MyQueue chosenQueue = queues[choiceNumber - 1];

                    System.out.println("Your ticket number is " + chosenQueue.getCounter() + ".");
                    chosenQueue.enqueue();
                }

                System.out.println("Choose the reason for your visit:");
                for (String[] menuItem : menu) {
                    System.out.printf("  %-3s %s%n", menuItem[0], menuItem[1]);
                }
                System.out.println();
            }
        }
    }
}
