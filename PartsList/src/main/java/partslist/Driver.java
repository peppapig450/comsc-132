package partslist;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of parts you will enter: ");
        int inventorySize = Integer.parseInt(input.nextLine());

        Inventory partsInventory = new Inventory(inventorySize);

        for (int i = 0; i < inventorySize; ++i) {
            System.out.println();
            System.out.println("Entry #" + (i + 1) + "....");

            System.out.print("   Enter the part description: ");
            String partDescription = input.nextLine();

            System.out.print("   Enter the part number: ");
            String partNumber = input.nextLine();

            System.out.print("   Enter the part quantity: ");
            int partQuantity = Integer.parseInt(input.nextLine());

            partsInventory.insert(partNumber, partDescription, partQuantity);
        }

        System.out.println();
        partsInventory.print();

        System.out.print("\nEnter part number to search for: ");
        String searchNumber = input.nextLine();

        int partsQuantity = partsInventory.find(searchNumber);
        System.out.println("\nQuantity in stock: " + partsQuantity + ".");

        System.out.print("\nEnter part number for part to remove: ");
        String partToRemove = input.nextLine();
        System.out.println();

        partsInventory.remove(partToRemove);

        partsInventory.print();
        input.close();
    }
}
