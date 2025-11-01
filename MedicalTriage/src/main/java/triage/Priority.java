package triage;

import java.util.Scanner;

public class Priority {

    private class Node {
        private String name;
        private short priority;
        private Node next;
    }

    private Node front = null;

    Priority() {
        this.front = null;
    }

    public void enqueue(String name, short pri) {
        Node newPatient = new Node();
        newPatient.name = name;
        newPatient.priority = pri;
        newPatient.next = null;

        if (isEmpty()) {
            this.front = newPatient;
        } else {
            Node current = this.front;
            Node previous = null;

            while (current != null && pri < current.priority) {
                previous = current;
                current = current.next;
            }

            if (previous == null) {
                newPatient.next = this.front;
                this.front = newPatient;
            } else {
                newPatient.next = current;
                previous.next = newPatient;
            }
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            this.front = this.front.next;
        }
    }

    public String peek() {
        if (!isEmpty()) {
            return this.front.name;
        } else {
            return "";
        }
    }

    public boolean update(String name, short pri) {
        Node previous = null;
        Node current = this.front;

        while (current != null && !current.name.equalsIgnoreCase(name)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (previous == null) {
            this.front = current.next;
        } else {
            previous.next = current.next;
        }

        enqueue(name, pri);
        return true;
    }

    public boolean isEmpty() {
        return (this.front == null);
    }

    public static void main(String[] args) {
        Priority queue = new Priority();
        Scanner input = new Scanner(System.in);
        String userChoice = "";

        while (!userChoice.equals("q")) {
            System.out.println("-=- Menu -=-");
            System.out.printf("  %12s | %10s | %10s | %10s | %5s%n",
                    "(A)dd Patient",
                    "(P)eek Patient",
                    "(T)reat Patient",
                    "(U)pdate Patient",
                    "(Q)uit");
            System.out.printf("  %7s", "[APUQ]: ");
            userChoice = input.nextLine();

            if (userChoice.equalsIgnoreCase("a")) {
                String patientName = "";
                short priority;

                System.out.print("     ] Enter patient name: ");
                patientName = input.nextLine();

                System.out.println("     ] Priorities: 3=high, 2=med, 1=low");
                System.out.print("     ] Enter patient priority: ");
                priority = input.nextShort();
                input.nextLine();

                queue.enqueue(patientName, priority);
            } else if (userChoice.equalsIgnoreCase("t")) {
                if (queue.isEmpty()) {
                    System.out.println("     ] No patients in triage.");
                    continue;
                }

                String currentPatient = queue.peek();
                System.out.println("     ] Now treating: " + currentPatient);

                queue.dequeue();
            } else if (userChoice.equalsIgnoreCase("p")) {
                if (queue.isEmpty()) {
                    System.out.println("     ] No patients in triage.");
                    continue;
                }

                String nextPatient = queue.peek();
                System.out.println("     ] Next patient: " + nextPatient);
            } else if (userChoice.equalsIgnoreCase("u")) {
                String targetPatient = "";
                short newPriority;

                System.out.print("     ] Enter patient's name to update: ");
                targetPatient = input.nextLine();

                System.out.print("     ] Enter new priority: ");
                newPriority = input.nextShort();
                input.nextLine();

                boolean updateSuccessful = queue.update(targetPatient, newPriority);
                if (updateSuccessful) {
                    System.out.println("     ] Patient updated.");
                } else {
                    System.out.println("     ] Patient not found.");
                }
            } else if (userChoice.equalsIgnoreCase("q")) {
                System.out.println("     ] Have a fabulous day!");
            } else {
                System.out.println("     ] Invalid option. Please try again.");
            }
        }
    }
}
