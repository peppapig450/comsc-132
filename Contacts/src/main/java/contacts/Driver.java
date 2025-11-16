package contacts;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Contacts phoneBook = new Contacts();
        Scanner input = new Scanner(System.in);

        for (int i = 1; i < 9; ++i) {
            System.out.println("Contact #" + i + ":");
            System.out.print("First name: ");
            String firstName = input.nextLine();

            System.out.print("Last name: ");
            String lastName = input.nextLine();

            System.out.print("Phone Number: ");
            String phoneNumber = input.nextLine();

            phoneBook.add(lastName, firstName, phoneNumber);
            System.out.println("\n");
        }

        System.out.println("Entries in the Phone Book:");
        phoneBook.print();

        System.out.print("Enter a last name to search for: ");
        String searchTerm = input.nextLine();
        System.out.println("\n");

        System.out.println("Search Results:\n" + phoneBook.search(searchTerm));
        System.out.print("Enter a last name for the entry to remove: ");
        String removalTerm = input.nextLine();

        phoneBook.remove(removalTerm);

        System.out.println("\n\nEntries in the Phone Book:");
        phoneBook.print();
        input.close();
    }
}
